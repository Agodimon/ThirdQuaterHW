package com.bignerdranch.android.thirdquaterhw.di

import com.bignerdranch.android.thirdquaterhw.MainActivity
import com.bignerdranch.android.thirdquaterhw.RepoDetailsFragment
import com.bignerdranch.android.thirdquaterhw.UserDetailsFragment
import com.bignerdranch.android.thirdquaterhw.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface GitHubUsersModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserDetailsFragment(): UserDetailsFragment

    @ContributesAndroidInjector
    fun bindRepoDetailsFragment(): RepoDetailsFragment


}