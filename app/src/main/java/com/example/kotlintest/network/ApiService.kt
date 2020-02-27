package com.example.kotlintest.network

import com.example.kotlintest.model.main.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {

    @get:GET("users")
    val posts: Call<List<User>>
}