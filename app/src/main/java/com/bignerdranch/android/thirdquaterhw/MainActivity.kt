package com.bignerdranch.android.thirdquaterhw

import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.databinding.ActivityMainBinding
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.MainPresenter
import com.bignerdranch.android.thirdquaterhw.utils.CiceroneObject
import com.bignerdranch.android.thirdquaterhw.view.MainView
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private val navigator = AppNavigator(this, R.id.container)
    private val binding by viewBinding(ActivityMainBinding::bind)
    private val presenter by moxyPresenter { MainPresenter(CiceroneObject.router, AndroidScreens()) }


    override fun onResumeFragments() {
        super.onResumeFragments()
        CiceroneObject.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        CiceroneObject.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}
