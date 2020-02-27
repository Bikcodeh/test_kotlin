package com.example.kotlintest.model.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("street")
    @Expose
    var street: String? = null

    @SerializedName("suite")
    @Expose
    var suite: String? = null

    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("zipCode")
    @Expose
    var zipCode: String? = null

    @SerializedName("geo")
    @Expose
    var geo: Geo? = null
}