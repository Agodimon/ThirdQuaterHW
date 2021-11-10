package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.view.UserView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(private val router: Router, private val user: GithubUser) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}