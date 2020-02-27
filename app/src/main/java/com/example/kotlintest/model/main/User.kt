package com.example.kotlintest.model.main

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: String? = null
    
    @SerializedName("name")
    @Expose
    var name: String? = null
    
    @SerializedName("username")
    @Expose
    var username: String? = null
    
    @SerializedName("email")
    @Expose
    var email: String? = null
    
    @SerializedName("address")
    @Expose
    var Address: Address? = null
    
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    
    @SerializedName("website")
    @Expose
    var website: String? = null
    
    @SerializedName("company")
    @Expose
    var Company: Company? = null
}