package com.android.apppedia.data

import com.google.gson.annotations.SerializedName

data class Application_info (

    @SerializedName("public_id")
    var public_id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("developer_name")
    var developer_name: String,

    @SerializedName("developer_public_id")
    var developer_public_id: String,

    @SerializedName("rating_total")
    var rating_total: String,

    @SerializedName("rating_average")
    var rating_average: String,

    @SerializedName("rating_five")
    var rating_five: String,

    @SerializedName("rating_four")
    var rating_four: String,

    @SerializedName("rating_three")
    var rating_three: String,

    @SerializedName("rating_two")
    var rating_two: String,

    @SerializedName("rating_one")
    var rating_one: String,

    @SerializedName("install")
    var install: String,

    @SerializedName("install_link")
    var install_link: String,

    @SerializedName("image_logo")
    var image_logo: String,

    @SerializedName("price")
    var price: String,

    @SerializedName("update_date")
    var update_date: String,

    @SerializedName("size")
    var size: String,

    @SerializedName("version_current")
    var version_current: String,

    @SerializedName("version_needs")
    var version_needs: String,

    @SerializedName("contents_grade")
    var contents_grade: String,

    @SerializedName("interaction")
    var interaction: String,

    @SerializedName("in_app_products")
    var in_app_products: String,

    @SerializedName("related_name")
    var related_name: String,

    @SerializedName("related_link")
    var related_link: String
)