package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun userDetails(user: GithubUser): Screen
    fun repoDetails (user: GithubUser, repo: UserRepo): Screen
}