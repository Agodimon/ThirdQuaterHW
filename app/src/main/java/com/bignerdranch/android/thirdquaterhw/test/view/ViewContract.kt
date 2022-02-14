package com.bignerdranch.android.thirdquaterhw.test.view

import com.bignerdranch.android.thirdquaterhw.test.model.SearchResult

internal interface ViewContract {
    fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    )

    fun displayError()
    fun displayError(error: String)
    fun displayLoading(show: Boolean)
}
