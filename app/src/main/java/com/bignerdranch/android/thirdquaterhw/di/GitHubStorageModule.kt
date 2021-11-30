package com.bignerdranch.android.thirdquaterhw.di

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import dagger.Module
import javax.inject.Singleton

@Module
interface GitHubStorageModule {

    @Singleton
    fun provideGitHubDatabaseStorage(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "github.db")
            .build()
}