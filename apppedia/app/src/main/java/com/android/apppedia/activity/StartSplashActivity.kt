package com.android.apppedia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.apppedia.R
import com.android.apppedia.repository.App

class StartSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_splash)

        Handler().postDelayed({
            if (App.prefs.MAIN.toString() == "") App.prefs.MAIN = "1"
            if (App.prefs.BEFORE.toString() == "") App.prefs.BEFORE = "1"
            if (App.prefs.VS_ONE.toString() == "") App.prefs.VS_ONE = "string"
            if (App.prefs.VS_TWO.toString() == "") App.prefs.VS_TWO = "string"
            if (App.prefs.VS_THREE.toString() == "") App.prefs.VS_THREE = "string"
            if (App.prefs.VS_FOUR.toString() == "") App.prefs.VS_FOUR = "string"
            if (App.prefs.VS_FIVE.toString() == "") App.prefs.VS_FIVE = "string"
            if (App.prefs.CATEGORY.toString() == "") App.prefs.CATEGORY = "Video Players"
            if (App.prefs.DEVELOPER.toString() == "") App.prefs.DEVELOPER = "Google LLC"
            if (App.prefs.RATING_TOTAL_UPPER.toString() == "") App.prefs.RATING_TOTAL_UPPER = "500000000"
            if (App.prefs.RATING_TOTAL_LOWER.toString() == "") App.prefs.RATING_TOTAL_LOWER = "1"
            if (App.prefs.RATING_AVERAGE_UPPER.toString() == "") App.prefs.RATING_AVERAGE_UPPER = "5.00"
            if (App.prefs.RATING_AVERAGE_LOWER.toString() == "") App.prefs.RATING_AVERAGE_LOWER = "0.00"
            if (App.prefs.INSTALL_UPPER.toString() == "") App.prefs.INSTALL_UPPER = "5000000000"
            if (App.prefs.INSTALL_LOWER.toString() == "") App.prefs.INSTALL_LOWER = "1"
            if (App.prefs.PRICE_UPPER.toString() == "") App.prefs.PRICE_UPPER = "99.99"
            if (App.prefs.PRICE_LOWER.toString() == "") App.prefs.PRICE_LOWER = "0.00"
            if (App.prefs.VERSION_NEEDS.toString() == "") App.prefs.VERSION_NEEDS = "10"
            if (App.prefs.FUNCTION_FIVE.toString() == "") App.prefs.FUNCTION_FIVE = "FIRST"
            if (App.prefs.FUNCTION_FOUR.toString() == "") App.prefs.FUNCTION_FOUR = "SECOND"
            if (App.prefs.FUNCTION_THREE.toString() == "") App.prefs.FUNCTION_THREE = "THIRD"
            if (App.prefs.FUNCTION_TWO.toString() == "") App.prefs.FUNCTION_TWO = "FORTH"
            if (App.prefs.FUNCTION_ONE.toString() == "") App.prefs.FUNCTION_ONE = "FIFTH"

            val intent = Intent(this, StartLogInActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
