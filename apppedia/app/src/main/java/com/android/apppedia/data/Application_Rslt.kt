package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_Rslt (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("rating_average")
    var rating_average: String,

    @SerializedName("image_logo")
    var image_logo: String,

    @SerializedName("price")
    var price: String
)