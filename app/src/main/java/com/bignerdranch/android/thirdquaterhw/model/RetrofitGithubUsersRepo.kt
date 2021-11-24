package com.bignerdranch.android.thirdquaterhw.model

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsersRepo(private val api: IDataSource) : IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
    override fun getUserRepoList(login: String): Single<List<UserRepo>> =
        api.getUserRepoList(login).subscribeOn(Schedulers.io())
}