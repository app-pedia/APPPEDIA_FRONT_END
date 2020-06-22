package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Auth (
        @SerializedName("email")
        var email: String,
        @SerializedName("password")
        var password: String
)