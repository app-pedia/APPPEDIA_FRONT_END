package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_Srch (

    @SerializedName("word")
    var word: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("developer_name")
    var developer_name: String,

    @SerializedName("rating_upper_total")
    var rating_total_upper: String,

    @SerializedName("rating_lower_total")
    var rating_total_lower: String,

    @SerializedName("rating_upper_average")
    var rating_average_upper: String,

    @SerializedName("rating_lower_average")
    var rating_average_lower: String,

    @SerializedName("install_upper")
    var install_upper: String,

    @SerializedName("install_lower")
    var install_lower: String,

    @SerializedName("price_upper")
    var price_upper: String,

    @SerializedName("price_lower")
    var price_lower: String,

    @SerializedName("version_needs")
    var version_needs: String,

    @SerializedName("function_five")
    var function_five: String,

    @SerializedName("function_four")
    var function_four: String,

    @SerializedName("function_three")
    var function_three: String,

    @SerializedName("function_two")
    var function_two: String,

    @SerializedName("function_one")
    var function_one: String
)