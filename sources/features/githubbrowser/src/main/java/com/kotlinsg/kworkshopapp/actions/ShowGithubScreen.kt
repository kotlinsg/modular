package com.kotlinsg.kworkshopapp.actions

import android.content.Context
import android.content.Intent
import com.kotlinsg.kworkshopapp.github.GithubActivity

class ShowGithubScreenActionRealImpl : ShowGithubScreenAction {
    override fun show(context: Context) {
        context.startActivity(Intent(context, GithubActivity::class.java))
    }
}

