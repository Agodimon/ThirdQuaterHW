package com.bignerdranch.android.thirdquaterhw.test.view

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.thirdquaterhw.R
import com.bignerdranch.android.thirdquaterhw.test.model.SearchResult
import com.bignerdranch.android.thirdquaterhw.test.presenter.PresenterContract
import com.bignerdranch.android.thirdquaterhw.test.presenter.SearchPresenter
import com.bignerdranch.android.thirdquaterhw.test.repository.GitHubApi
import com.bignerdranch.android.thirdquaterhw.test.repository.GitHubRepository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainTestActivity : AppCompatActivity(), ViewContract {

    private val adapter = SearchResultAdapter()
    private val presenter: PresenterContract = SearchPresenter(this, createRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitytest_main)
        setUI()
    }

    private fun setUI() {
        setQueryListener()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        findViewById<RecyclerView>(R.id.recyclerView).setHasFixedSize(true)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter
    }

    private fun setQueryListener() {
        findViewById<EditText>(R.id.searchEditText).setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = findViewById<EditText>(R.id.searchEditText).text.toString()
                if (query.isNotBlank()) {
                    presenter.searchGitHub(query)
                    return@OnEditorActionListener true
                } else {
                    Toast.makeText(
                        this@MainTestActivity,
                        getString(R.string.enter_search_word),
                        Toast.LENGTH_SHORT
                    ).show()
                    return@OnEditorActionListener false
                }
            }
            false
        })
    }

    private fun createRepository(): GitHubRepository {
        return GitHubRepository(createRetrofit().create(GitHubApi::class.java))
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun displaySearchResults(
        searchResults: List<SearchResult>,
        totalCount: Int
    ) {
        adapter.updateResults(searchResults)
        findViewById<TextView>(R.id.resultsCountTextView).text =
            String.format(Locale.getDefault(), getString(R.string.results_count), totalCount)
    }

    override fun displayError() {
        Toast.makeText(this, getString(R.string.undefined_error), Toast.LENGTH_SHORT).show()
    }

    override fun displayError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun displayLoading(show: Boolean) {
        if (show) {
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
        } else {
            findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
        }
    }

    companion object {
        const val BASE_URL = "https://api.github.com"
    }
}
