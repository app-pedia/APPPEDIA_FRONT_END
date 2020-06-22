package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Contact_info (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("user_email")
    var user_email: String,

    @SerializedName("title")
    var title: String
)