package com.example.kotlintest.activity.main.view

import com.example.kotlintest.model.main.User

interface MainActivityImpl {

    fun showProgress()
    fun hideProgress()

    fun setDataToRecycler(user: List<User>?)

    fun showError(throwable: Throwable)
}