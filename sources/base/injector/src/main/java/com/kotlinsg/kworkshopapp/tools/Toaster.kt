package com.kotlinsg.kworkshopapp.tools

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ToasterImpl @Inject constructor(
        val appContext: Context
) : Toaster {
    override fun show(msg: String) {
        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show()
    }
}