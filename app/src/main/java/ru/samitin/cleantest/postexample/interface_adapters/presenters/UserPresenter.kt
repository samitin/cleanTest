package ru.samitin.cleantest.postexample.interface_adapters.presenters

import ru.samitin.cleantest.postexample.entities.User

interface UserPresenter {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showUser(user: User?)
        fun showError()
        fun showResult()
    }

    fun onStart()
    fun onStop()
    fun onUserAction()
}