package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.view.IItemView

interface RepoItemView: IItemView {
    fun setTitle(text: String)
}