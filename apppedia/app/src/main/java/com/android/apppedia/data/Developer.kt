package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Developer (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("country")
    var country: String,

    @SerializedName("address")
    var address: String,

    @SerializedName("web")
    var web: String,

    @SerializedName("rating_total")
    var rating_total: String,

    @SerializedName("rating_average")
    var rating_average: String,

    @SerializedName("install_achieved")
    var install_achieved: String
)