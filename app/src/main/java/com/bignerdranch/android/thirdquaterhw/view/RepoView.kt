package com.bignerdranch.android.thirdquaterhw.view

import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface RepoView : MvpView {
    @SingleState
    fun setRepoDetails (repo: UserRepo)
}