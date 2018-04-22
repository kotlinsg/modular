package com.kotlinsg.kworkshopapp.notification.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import dagger.Binds
import dagger.Component
import dagger.Module

interface NotificationProvider {
	fun provideNotificationUseCase(): NotificationUseCase
}

@Module
interface NotificationModule {
    @Binds fun bindsNotificationUseCase(impl: NotificationUseCaseImpl): NotificationUseCase
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [NotificationModule::class])
interface NotificationComponent : NotificationProvider