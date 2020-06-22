package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_Comp (

    @SerializedName("public_id")
    var public_id: String,

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