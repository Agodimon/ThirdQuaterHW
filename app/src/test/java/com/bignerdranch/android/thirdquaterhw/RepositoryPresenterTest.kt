package com.bignerdranch.android.thirdquaterhw


import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class RepositoryPresenterTest {

    private lateinit var presenter: RepositoryPresenter

    @InjectMocks
    private lateinit var router: Router

    @Mock
    private lateinit var repository: GithubRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = RepositoryPresenter(router, repository)
    }

    @Test
    fun repositoryPresenterBackClick_Test() {
        presenter.backClick()
        verify(repository, times(1))
    }

}