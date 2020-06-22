package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Functionss (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("application_public_id")
    var application_public_id: String,

    @SerializedName("detail")
    var detail: String
)