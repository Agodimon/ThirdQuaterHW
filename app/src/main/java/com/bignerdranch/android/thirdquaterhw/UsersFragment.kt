package com.bignerdranch.android.thirdquaterhw

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.adapters.UsersRVAdapter
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentUsersBinding
import com.bignerdranch.android.thirdquaterhw.model.GithubUsersRepo
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.UsersPresenter
import com.bignerdranch.android.thirdquaterhw.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router, AndroidScreens())
    }
    private var adapter: UsersRVAdapter? = null

    private val vb by viewBinding(FragmentUsersBinding::bind)

    override fun init() = with(vb) {
        rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}