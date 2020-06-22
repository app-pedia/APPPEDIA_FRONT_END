package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_Rult (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("image_logo")
    var image_logo: String,

    @SerializedName("score_all")
    var score_all: String,

    @SerializedName("score_rating_average")
    var score_rating_average: String,

    @SerializedName("score_rating_total")
    var score_rating_total: String,

    @SerializedName("score_install")
    var score_install: String,

    @SerializedName("score_function_five")
    var score_function_five: String,

    @SerializedName("score_function_four")
    var score_function_four: String,

    @SerializedName("score_function_three")
    var score_function_three: String,

    @SerializedName("score_function_two")
    var score_function_two: String,

    @SerializedName("score_function_one")
    var score_function_one: String
)