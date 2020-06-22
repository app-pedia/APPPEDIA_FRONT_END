package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Favorites_Save (

        @SerializedName("user_email")
        var user_email: String,

        @SerializedName("application_public_id")
        var application_public_id: String
)