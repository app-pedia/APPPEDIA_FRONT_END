package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_Plus (
    @SerializedName("category")
    var category: String,

    @SerializedName("related_name")
    var related_name: String,

    @SerializedName("related_link")
    var related_link: String
)