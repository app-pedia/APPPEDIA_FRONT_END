package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("email")
    var email: String,

    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String,

    @SerializedName("device_name")
    var device_name: String,

    @SerializedName("android_version")
    var android_version: String
)