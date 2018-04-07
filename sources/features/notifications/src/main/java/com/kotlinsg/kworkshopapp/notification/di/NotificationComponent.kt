package com.kotlinsg.kworkshopapp.notification.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.di.NotificaitonProvider
import dagger.Binds
import dagger.Component
import dagger.Module

@Module
interface NotificationModule {
    @Binds fun bindsNotificationUseCase(impl: NotificationUseCaseImpl): NotificationUseCase
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [NotificationModule::class])
interface NotificationComponent : NotificaitonProvider