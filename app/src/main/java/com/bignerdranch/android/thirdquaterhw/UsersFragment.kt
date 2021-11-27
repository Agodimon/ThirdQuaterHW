package com.bignerdranch.android.thirdquaterhw

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.adapters.UsersRVAdapter
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentUsersBinding
import com.bignerdranch.android.thirdquaterhw.model.RetrofitGithubUsersRepo
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.GlideImageLoader
import com.bignerdranch.android.thirdquaterhw.presenter.UsersPresenter
import com.bignerdranch.android.thirdquaterhw.utils.ApiHolder
import com.bignerdranch.android.thirdquaterhw.utils.CiceroneObject
import com.bignerdranch.android.thirdquaterhw.view.UsersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }


    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            AndroidSchedulers.mainThread(),
            RetrofitGithubUsersRepo(ApiHolder.api),
            CiceroneObject.router, AndroidScreens(),
        )
    }

    private var adapter: UsersRVAdapter? = null

    private val viewBinding by viewBinding(FragmentUsersBinding::bind)

    override fun init() {
        viewBinding.rvUsers.layoutManager = LinearLayoutManager(context)

        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())

        viewBinding.rvUsers.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}


