package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Favorites_List (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("application_public_id")
    var application_public_id: String,

    @SerializedName("application_name")
    var application_name: String,

    @SerializedName("application_category")
    var application_category: String,

    @SerializedName("application_rating_average")
    var application_rating_average: String,

    @SerializedName("application_image_logo")
    var application_image_logo: String,

    @SerializedName("application_price")
    var application_price: String
)