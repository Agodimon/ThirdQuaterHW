package com.bignerdranch.android.thirdquaterhw.model.repository

import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import io.reactivex.rxjava3.core.Single

open class IGithubRepositoriesRepo {
    fun getRepositories(user: GithubUser)
}
