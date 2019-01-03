package com.kotlinsg.kworkshopapp.github

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.app.R
import com.kotlinsg.kworkshopapp.di.GithubActivityComponent
import com.kotlinsg.kworkshopapp.notification.di.NotificationUseCase
import com.kotlinsg.kworkshopapp.tools.Toaster
import javax.inject.Inject

class GithubActivity : AppCompatActivity() {

    @Inject lateinit var toaster: Toaster
    @Inject lateinit var useCase: GithubUseCase
    @Inject lateinit var notifications: NotificationUseCase

    lateinit var refreshButton: Button
    lateinit var starsCountText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)
        inject()
        refreshButton = findViewById(R.id.stars_refresh) as Button
        starsCountText = findViewById(R.id.stars_count_text) as TextView

        refreshButton.setOnClickListener { useCase.loadInfoFromGithub(onLoaded = ::updateUI, onError = ::updateErrorUI) }

        notifications.showMessage()
    }

    fun inject() {
        GithubActivityComponent.Initializer
                .init((applicationContext as App).getAppComponent())
                .inject(this@GithubActivity)
    }

    private fun updateErrorUI(error: Throwable) {
        toaster.show(error.message ?: "unable to load")
    }

    private fun updateUI(result: GithubProject) {
        starsCountText.setText("${result.name} stars count: ${result.stargazers_count}")
    }
}
