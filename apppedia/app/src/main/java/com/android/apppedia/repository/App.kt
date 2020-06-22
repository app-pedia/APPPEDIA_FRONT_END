package com.android.apppedia.repository

import android.app.Application
import android.content.Context
import com.android.apppedia.repository.SharedPreferences

class App : Application() {

    companion object {
        lateinit var prefs : SharedPreferences
    }

    override fun onCreate() {
        prefs = SharedPreferences(applicationContext)
        super.onCreate()
    }
}