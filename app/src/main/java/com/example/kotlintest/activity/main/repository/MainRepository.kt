package com.example.kotlintest.activity.main.repository

import com.example.kotlintest.activity.main.presenter.MainPresenterImpl
import com.example.kotlintest.model.main.User
import com.example.kotlintest.network.ApiService
import com.example.kotlintest.network.RetrofitClient.Companion.getApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(val presenter: MainPresenterImpl): MainRepositoryImpl {

    private val call: Call<List<User>>
    private val apiService: ApiService? = getApiService()

    init {
        call = apiService!!.posts
    }

    override fun getUsersFromApi() {
        call.enqueue(object: Callback<List<User>>{

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                presenter.onErrorData(t)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                presenter.onSuccessData(response.body())
            }
        })
    }
}