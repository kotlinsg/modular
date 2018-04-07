package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.notification.di.NotificationComponent
import com.kotlinsg.kworkshopapp.notification.di.NotificationProvider
import dagger.Component

@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationProvider::class, NotificationProvider::class),
        modules = arrayOf(GithubActivityModule::class))
interface GithubActivityComponent {
    fun inject(activity: GithubActivity)

    class Initializer private constructor() {
        companion object {
            fun init(
                    applicationProvider: ApplicationProvider
            ): GithubActivityComponent {

                val notificationProvider = NotificationComponent.Initializer
                        .init(applicationProvider)

                return DaggerGithubActivityComponent.builder()
                        .applicationProvider(applicationProvider)
                        .notificationProvider(notificationProvider)
                        .build()
            }
        }
    }
}


