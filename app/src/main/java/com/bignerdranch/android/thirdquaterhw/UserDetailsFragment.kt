package com.bignerdranch.android.thirdquaterhw

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.adapters.RepoRVAdapter
import com.bignerdranch.android.thirdquaterhw.databinding.FragmentDetailsBinding
import com.bignerdranch.android.thirdquaterhw.model.database.Database
import com.bignerdranch.android.thirdquaterhw.model.network.AndroidNetworkStatus
import com.bignerdranch.android.thirdquaterhw.model.repository.RetrofitGithubUserReposList
import com.bignerdranch.android.thirdquaterhw.model.user.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.repository.RetrofitGithubUsersRepo
import com.bignerdranch.android.thirdquaterhw.model.repository.RoomRepositoriesCache
import com.bignerdranch.android.thirdquaterhw.presenter.BackButtonListener
import com.bignerdranch.android.thirdquaterhw.presenter.GlideImageLoader
import com.bignerdranch.android.thirdquaterhw.presenter.UserDetailsPresenter
import com.bignerdranch.android.thirdquaterhw.utils.ApiHolder
import com.bignerdranch.android.thirdquaterhw.utils.CiceroneObject
import com.bignerdranch.android.thirdquaterhw.view.UserDetailsView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment(
    private val networkStatus: AndroidNetworkStatus,
    private val user: GithubUser,
    private val db: Database
) :
    MvpAppCompatFragment(R.layout.fragment_details), BackButtonListener, UserDetailsView {

    companion object {
        fun newInstance(
            networkStatus: AndroidNetworkStatus,
            user: GithubUser,
            db: Database
        ): Fragment = UserDetailsFragment(networkStatus, user, db)
    }

    private val userReposList = RoomRepositoriesCache.getInstance()

    private val presenter by moxyPresenter {
        UserDetailsPresenter(
            networkStatus,
            RetrofitGithubUserReposList(ApiHolder.api, networkStatus, db, userReposList),
            CiceroneObject.router,
            user,
            AndroidSchedulers.mainThread(),
            AndroidScreens()
        )
    }

    private val viewBinding by viewBinding(FragmentDetailsBinding::bind)


    private var adapter: RepoRVAdapter? = null

    override fun backPressed() = presenter.backPressed()

    override fun setUserPage(userData: GithubUser) {
        viewBinding.detailsName.text = userData.login
        userData.avatarUrl?.let { GlideImageLoader().loadInto(it, viewBinding.detailsUserImage) }

        viewBinding.rvRepos.layoutManager = LinearLayoutManager(context)
        adapter = RepoRVAdapter(presenter.userRepoListPresenter)
        viewBinding.rvRepos.adapter = adapter
    }

    override fun updateRepoList() {
        adapter?.notifyDataSetChanged()
    }

    override fun onLoadingRepoListError(throwable: Throwable) {
        Toast.makeText(
            context, "Error occurred while loading repo list: $throwable", Toast.LENGTH_SHORT
        ).show()
    }
}