package com.bignerdranch.android.thirdquaterhw.view

import com.bignerdranch.android.thirdquaterhw.UserFragment
import com.bignerdranch.android.thirdquaterhw.UsersFragment
import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.presenter.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }

    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}