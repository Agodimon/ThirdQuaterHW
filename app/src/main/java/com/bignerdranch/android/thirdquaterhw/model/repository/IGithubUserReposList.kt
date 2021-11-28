package com.bignerdranch.android.thirdquaterhw.model.repository

import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUserReposList {
    fun getUserRepoList(user: GithubUser): Single<List<UserRepo>>
}