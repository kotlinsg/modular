package com.kotlinsg.kworkshopapp.notification.di

import com.kotlinsg.kworkshopapp.tools.Toaster
import javax.inject.Inject


class NotificationUseCaseImpl @Inject constructor(
        val toaster: Toaster
) : NotificationUseCase {
    override fun showMessage() {
        toaster.show("notifications are not implemented")
    }
}