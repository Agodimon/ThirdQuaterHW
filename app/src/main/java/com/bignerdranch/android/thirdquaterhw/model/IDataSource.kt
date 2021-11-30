package com.bignerdranch.android.thirdquaterhw.model

import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("/users/{username}/repos")
    fun getUserRepoList(@Path("username") login: String): Single<List<UserRepo>>
}