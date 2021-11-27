package com.bignerdranch.android.thirdquaterhw.presenter

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}