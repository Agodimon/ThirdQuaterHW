package com.bignerdranch.android.thirdquaterhw

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentUserBinding
import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.UserPresenter
import com.bignerdranch.android.thirdquaterhw.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    private val vb by viewBinding(FragmentUserBinding::bind)
    private val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER) as GithubUser
        UserPresenter(App.instance.router, user)
    }

    override fun setLogin(text: String) {
        text.also { vb.userLoginText.text = it }
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER = "USER"
        fun newInstance(user: GithubUser) =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER, user)
                }
            }
    }
}