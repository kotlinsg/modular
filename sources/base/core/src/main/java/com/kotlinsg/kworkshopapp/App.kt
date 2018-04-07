package com.kotlinsg.kworkshopapp

import android.content.Context
import com.kotlinsg.kworkshopapp.di.ApplicationProvider


interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}