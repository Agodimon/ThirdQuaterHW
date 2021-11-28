package com.bignerdranch.android.thirdquaterhw

import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.presenter.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun userDetails(user: GithubUser) = FragmentScreen { UserDetailsFragment.newInstance(user) }
    override fun repoDetails(user: GithubUser, repo: UserRepo) = FragmentScreen { RepoDetailsFragment.newInstance(user, repo) }
}