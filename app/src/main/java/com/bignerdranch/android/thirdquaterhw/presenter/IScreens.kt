package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(networkStatus: AndroidNetworkStatus): Screen
    fun userDetails(user: GithubUser, db: Database): Screen
    fun repoDetails(user: GithubUser, repo: UserRepo): Screen
}