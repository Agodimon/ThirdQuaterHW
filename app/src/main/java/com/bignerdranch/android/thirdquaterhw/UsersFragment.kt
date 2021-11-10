package com.bignerdranch.android.thirdquaterhw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.thirdquaterhw.adapters.UsersRVAdapter
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentUsersBinding
import com.bignerdranch.android.thirdquaterhw.model.GithubUsersRepo
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.UsersPresenter
import com.bignerdranch.android.thirdquaterhw.view.AndroidScreens
import com.bignerdranch.android.thirdquaterhw.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router, AndroidScreens())
    }
    private var adapter: UsersRVAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}