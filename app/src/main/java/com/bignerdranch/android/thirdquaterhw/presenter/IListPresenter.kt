package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.view.IItemView
import com.bignerdranch.android.thirdquaterhw.view.UserItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>