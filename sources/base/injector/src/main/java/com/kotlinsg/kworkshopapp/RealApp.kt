package com.kotlinsg.kworkshopapp

import android.app.Application
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.ApplicationProvider
import com.kotlinsg.kworkshopapp.tools.Toaster
import javax.inject.Inject


class RealApp : Application(), App {

    @Inject lateinit var toaster: Toaster
    val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this@RealApp) }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        toaster.show("app injected")
    }

    override fun getAppComponent(): ApplicationProvider = appComponent
}