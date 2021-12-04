package com.bignerdranch.android.thirdquaterhw

import com.bignerdranch.android.thirdquaterhw.di.DaggerAppComponent
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class    AppDagger : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<AppDagger> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .withMainThreadScheduler(AndroidSchedulers.mainThread())
            .withAndroidScreens(AndroidScreens())
            .withAndroidNetworkStatus(AndroidNetworkStatus(applicationContext))
            .build()

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {}
    }
}