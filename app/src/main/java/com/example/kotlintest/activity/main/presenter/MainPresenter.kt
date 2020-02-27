package com.example.kotlintest.activity.main.presenter

import com.example.kotlintest.activity.main.repository.MainRepository
import com.example.kotlintest.activity.main.repository.MainRepositoryImpl
import com.example.kotlintest.activity.main.view.MainActivityImpl
import com.example.kotlintest.model.main.User

class MainPresenter(val view: MainActivityImpl) : MainPresenterImpl {

    val repository: MainRepositoryImpl = MainRepository(this)

    override fun getUsers() {
        view.showProgress()
        repository.getUsersFromApi()
    }

    override fun onSuccessData(list: List<User>?) {
        view.hideProgress()
        view.setDataToRecycler(list)
    }

    override fun onErrorData(throwable: Throwable) {
        view.hideProgress()
        view.showError(throwable)
    }
}