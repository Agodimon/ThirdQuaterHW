package com.bignerdranch.android.thirdquaterhw

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.adapters.UsersRVAdapter
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentUsersBinding
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.bignerdranch.android.thirdquaterhw.model.repository.RetrofitGithubUserReposList
import com.bignerdranch.android.thirdquaterhw.model.repository.RetrofitGithubUsersRepo
import com.bignerdranch.android.thirdquaterhw.model.repository.RoomRepositoriesCache
import com.bignerdranch.android.thirdquaterhw.model.user.RoomUserCache
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.GlideImageLoader
import com.bignerdranch.android.thirdquaterhw.presenter.UsersPresenter
import com.bignerdranch.android.thirdquaterhw.utils.ApiHolder
import com.bignerdranch.android.thirdquaterhw.utils.CiceroneObject
import com.bignerdranch.android.thirdquaterhw.view.UsersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment(private val networkStatus: AndroidNetworkStatus) : MvpAppCompatFragment
    (R.layout.fragment_users),
    UsersView, BackButtonListener {

    companion object {
        fun newInstance(networkStatus: AndroidNetworkStatus): Fragment =
            UsersFragment(networkStatus)
    }

    private val usersCache: RoomUserCache = RoomUserCache.getInstance()
    private val userReposList = RoomRepositoriesCache.getInstance()

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            networkStatus,
            AndroidSchedulers.mainThread(),
            RetrofitGithubUsersRepo(
                ApiHolder.api,
                networkStatus,
                Database.getInstance(),
                usersCache
            ),
            RetrofitGithubUserReposList(
                ApiHolder.api,
                networkStatus,
                Database.getInstance(),
                userReposList
            ),
            CiceroneObject.router,
            AndroidScreens()
        )
    }
    private val viewBinding by viewBinding(FragmentUsersBinding::bind)

    private var adapter: UsersRVAdapter? = null


    override fun init() {
        viewBinding.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        viewBinding.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}


