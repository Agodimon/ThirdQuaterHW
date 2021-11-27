package com.bignerdranch.android.thirdquaterhw.model

import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getUserRepoList(login: String): Single<List<UserRepo>>
    //fun getUserRepo(url: String): Maybe<List<IGithubUsersRepo>>
}