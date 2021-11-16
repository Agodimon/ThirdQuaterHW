package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}