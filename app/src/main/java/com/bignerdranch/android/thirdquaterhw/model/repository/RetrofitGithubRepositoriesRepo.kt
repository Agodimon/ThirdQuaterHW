package com.bignerdranch.android.thirdquaterhw.model.repository

import com.bignerdranch.android.thirdquaterhw.model.IDataSource
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.network.INetworkStatus
import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubRepositoriesRepo(val api: IDataSource, val networkStatus:
INetworkStatus, val db: Database
) : IGithubRepositoriesRepo {
    override fun getRepositories(user: GithubUser) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                user.reposUrl?.let { url ->
                    api.getRepositories(url)
                        .flatMap { repositories ->
                            Single.fromCallable {
                                val roomUser = user.login?.let {
                                    db.userDao.findByLogin(it) } ?: throw RuntimeException("No such user in cache")
                                val roomRepos = repositories.map {
                                    RoomGithubRepository(it.id ?: "", it.name ?: "", it.forksCount ?: 0,
                                        roomUser.id) }
                                db.repositoryDao.insert(roomRepos)
                                repositories
                            }
                        }
                } ?: Single.error<List<GithubRepository>>(RuntimeException("User has no repos url")).subscribeOn(Schedulers.io())
            } else {
                Single.fromCallable {
                    val roomUser = user.login?.let { db.userDao.findByLogin(it) } ?:
                    throw RuntimeException("No such user in cache")
                    db.repositoryDao.findForUser(roomUser.id).map {
                        GithubRepository(it.id, it.name, it.forksCount) }
                }
            }
        }.subscribeOn(Schedulers.io())}