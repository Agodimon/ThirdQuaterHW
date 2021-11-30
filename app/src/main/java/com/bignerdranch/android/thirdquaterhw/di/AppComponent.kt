package com.bignerdranch.android.thirdquaterhw.di

import android.content.Context
import com.bignerdranch.android.thirdquaterhw.AndroidScreens
import com.bignerdranch.android.thirdquaterhw.AppDagger
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        GitHubUsersModule::class,
        GitHubStorageModule::class]
)
interface AppComponent : AndroidInjector<AppDagger> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withMainThreadScheduler(mainThread: Scheduler): Builder

        @BindsInstance
        fun withAndroidScreens(screens: AndroidScreens): Builder

        @BindsInstance
        fun withAndroidNetworkStatus(networkStatus: AndroidNetworkStatus): Builder

        fun build(): AppComponent
    }
}