package com.example.kotlintest.activity.main.presenter

import com.example.kotlintest.model.main.User

interface MainPresenterImpl {

    fun getUsers()
    fun onSuccessData(list: List<User>?)
    fun onErrorData(throwable: Throwable)
}