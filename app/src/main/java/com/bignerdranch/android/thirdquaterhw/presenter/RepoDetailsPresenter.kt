package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import com.bignerdranch.android.thirdquaterhw.view.RepoView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class RepoDetailsPresenter (
    private val repo: UserRepo,
    private val user: GithubUser,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<RepoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setRepoDetails(repo)
    }

    fun backPressed(): Boolean {
        router.navigateTo(screens.userDetails(user, Database.getInstance()))
        return true
    }

}