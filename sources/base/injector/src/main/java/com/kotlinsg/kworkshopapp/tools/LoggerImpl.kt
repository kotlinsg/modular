package com.kotlinsg.kworkshopapp.tools

import android.util.Log
import com.kotlinsg.kworkshopapp.di.Logger


class LoggerImpl : Logger {
    override fun d(message:String) {
        Log.d("APP",message)
    }
}