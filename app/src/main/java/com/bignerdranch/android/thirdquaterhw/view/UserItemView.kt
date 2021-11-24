package com.bignerdranch.android.thirdquaterhw.view

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}