package com.android.apppedia.repository

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"

    val KEY_EMAIL = "email"
    val KEY_TOKEN = "Authorization"

    val KEY_MAIN = "mainpage"

    val KEY_BEFORE = "beforepage"

    val KEY_VS_ONE = "vs_one"
    val KEY_VS_TWO = "vs_two"
    val KEY_VS_THREE = "vs_three"
    val KEY_VS_FOUR = "vs_four"
    val KEY_VS_FIVE = "vs_five"

    val KEY_CATEGORY = "category"
    val KEY_DEVELOPER = "developer_name"
    val KEY_RATING_TOTAL_UPPER = "rating_total_upper"
    val KEY_RATING_TOTAL_LOWER = "rating_total_lower"
    val KEY_RATING_AVERAGE_UPPER = "rating_average_upper"
    val KEY_RATING_AVERAGE_LOWER = "rating_average_lower"
    val KEY_INSTALL_UPPER = "install_upper"
    val KEY_INSTALL_LOWER = "install_lower"
    val KEY_PRICE_UPPER = "price_upper"
    val KEY_PRICE_LOWER = "price_lower"
    val KEY_VERSION_NEEDS = "version_needs"
    val KEY_FUNCTION_FIVE = "function_five"
    val KEY_FUNCTION_FOUR = "function_four"
    val KEY_FUNCTION_THREE = "function_three"
    val KEY_FUNCTION_TWO = "function_two"
    val KEY_FUNCTION_ONE = "function_one"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    fun setV(key:String, value:String?) {
        prefs.edit().putString(key, value).apply()
    }

    fun getV(key:String):String? {
        return prefs.getString(key, "")
    }

    var EMAIL: String?
        get() = prefs.getString(KEY_EMAIL, "")
        set(value) = prefs.edit().putString(KEY_EMAIL, value).apply()

    var TOKEN: String?
        get() = prefs.getString(KEY_TOKEN, "")
        set(value) = prefs.edit().putString(KEY_TOKEN, value).apply()

    var MAIN: String?
        get() = prefs.getString(KEY_MAIN, "")
        set(value) = prefs.edit().putString(KEY_MAIN, value).apply()

    var BEFORE: String?
        get() = prefs.getString(KEY_BEFORE, "")
        set(value) = prefs.edit().putString(KEY_BEFORE, value).apply()

    var VS_ONE: String?
        get() = prefs.getString(KEY_VS_ONE, "")
        set(value) = prefs.edit().putString(KEY_VS_ONE, value).apply()

    var VS_TWO: String?
        get() = prefs.getString(KEY_VS_TWO, "")
        set(value) = prefs.edit().putString(KEY_VS_TWO, value).apply()

    var VS_THREE: String?
        get() = prefs.getString(KEY_VS_THREE, "")
        set(value) = prefs.edit().putString(KEY_VS_THREE, value).apply()

    var VS_FOUR: String?
        get() = prefs.getString(KEY_VS_FOUR, "")
        set(value) = prefs.edit().putString(KEY_VS_FOUR, value).apply()

    var VS_FIVE: String?
        get() = prefs.getString(KEY_VS_FIVE, "")
        set(value) = prefs.edit().putString(KEY_VS_FIVE, value).apply()

    var CATEGORY: String?
        get() = prefs.getString(KEY_CATEGORY, "")
        set(value) = prefs.edit().putString(KEY_CATEGORY, value).apply()

    var DEVELOPER: String?
        get() = prefs.getString(KEY_DEVELOPER, "")
        set(value) = prefs.edit().putString(KEY_DEVELOPER, value).apply()

    var RATING_TOTAL_UPPER: String?
        get() = prefs.getString(KEY_RATING_TOTAL_UPPER, "")
        set(value) = prefs.edit().putString(KEY_RATING_TOTAL_UPPER, value).apply()

    var RATING_TOTAL_LOWER: String?
        get() = prefs.getString(KEY_RATING_TOTAL_LOWER, "")
        set(value) = prefs.edit().putString(KEY_RATING_TOTAL_LOWER, value).apply()

    var RATING_AVERAGE_UPPER: String?
        get() = prefs.getString(KEY_RATING_AVERAGE_UPPER, "")
        set(value) = prefs.edit().putString(KEY_RATING_AVERAGE_UPPER, value).apply()

    var RATING_AVERAGE_LOWER: String?
        get() = prefs.getString(KEY_RATING_AVERAGE_LOWER, "")
        set(value) = prefs.edit().putString(KEY_RATING_AVERAGE_LOWER, value).apply()

    var INSTALL_UPPER: String?
        get() = prefs.getString(KEY_INSTALL_UPPER, "")
        set(value) = prefs.edit().putString(KEY_INSTALL_UPPER, value).apply()

    var INSTALL_LOWER: String?
        get() = prefs.getString(KEY_INSTALL_LOWER, "")
        set(value) = prefs.edit().putString(KEY_INSTALL_LOWER, value).apply()

    var PRICE_UPPER: String?
        get() = prefs.getString(KEY_PRICE_UPPER, "")
        set(value) = prefs.edit().putString(KEY_PRICE_UPPER, value).apply()

    var PRICE_LOWER: String?
        get() = prefs.getString(KEY_PRICE_LOWER, "")
        set(value) = prefs.edit().putString(KEY_PRICE_LOWER, value).apply()

    var VERSION_NEEDS: String?
        get() = prefs.getString(KEY_VERSION_NEEDS, "")
        set(value) = prefs.edit().putString(KEY_VERSION_NEEDS, value).apply()

    var FUNCTION_FIVE: String?
        get() = prefs.getString(KEY_FUNCTION_FIVE, "")
        set(value) = prefs.edit().putString(KEY_FUNCTION_FIVE, value).apply()

    var FUNCTION_FOUR: String?
        get() = prefs.getString(KEY_FUNCTION_FOUR, "")
        set(value) = prefs.edit().putString(KEY_FUNCTION_FOUR, value).apply()

    var FUNCTION_THREE: String?
        get() = prefs.getString(KEY_FUNCTION_THREE, "")
        set(value) = prefs.edit().putString(KEY_FUNCTION_THREE, value).apply()

    var FUNCTION_TWO: String?
        get() = prefs.getString(KEY_FUNCTION_TWO, "")
        set(value) = prefs.edit().putString(KEY_FUNCTION_TWO, value).apply()

    var FUNCTION_ONE: String?
        get() = prefs.getString(KEY_FUNCTION_ONE, "")
        set(value) = prefs.edit().putString(KEY_FUNCTION_ONE, value).apply()
}