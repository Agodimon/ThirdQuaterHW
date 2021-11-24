package com.bignerdranch.android.thirdquaterhw.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("/users/{username}/repos")
    fun getUserRepoList (@Path("username") login: String): Single<List<UserRepo>>

//    @GET
//    fun fetchUserRepositories(@Url url: String): Single<List<IGithubUsersRepo>>
}