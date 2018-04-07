package com.kotlinsg.kworkshopapp.notification.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.tools.Toaster
import dagger.Component
import dagger.Module
import dagger.Provides

interface NotificationProvider {
    fun provideNotificationUseCase(): NotificationUseCase
}

@Module
class NotificationModule {
    @Provides fun providesNotificationUseCase(toaster: Toaster): NotificationUseCase =
            object : NotificationUseCase {
                override fun showMessage() {
                    toaster.show("notifications are not implemented")
                }
            }
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [NotificationModule::class])
interface NotificationComponent : NotificationProvider {
    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): NotificationProvider =
                    DaggerNotificationComponent.builder()
                            .mainToolsProvider(mainToolsProvider)
                            .build()
        }
    }
}