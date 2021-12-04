package com.bignerdranch.android.thirdquaterhw

import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.bignerdranch.android.thirdquaterhw.presenter.IScreens
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users(networkStatus: AndroidNetworkStatus) =
        FragmentScreen { UsersFragment.newInstance(networkStatus) }

    override fun userDetails(user: GithubUser, db: Database) =
        FragmentScreen { UserDetailsFragment.newInstance(user, db, "") }

    override fun repoDetails(user: GithubUser, repo: UserRepo) =
        FragmentScreen { RepoDetailsFragment.newInstance(user, repo) }
}