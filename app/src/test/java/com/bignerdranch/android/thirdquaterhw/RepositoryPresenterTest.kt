package com.bignerdranch.android.thirdquaterhw


import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.model.UserRepo
import com.bignerdranch.android.thirdquaterhw.presenter.IScreens
import com.bignerdranch.android.thirdquaterhw.presenter.RepoDetailsPresenter
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class RepositoryPresenterTest {

    private lateinit var presenter: RepoDetailsPresenter

    @InjectMocks
    private lateinit var router: Router



    @Mock
    private lateinit var repo: UserRepo

    @Mock
    private lateinit var user: GithubUser

    @Mock
    private lateinit var screens: IScreens


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = RepoDetailsPresenter(repo,user,router,screens)
    }

    @Test
    fun repositoryPresenterBackClick_Test() {
        presenter.backPressed()
        verify(repo, times(1))
    }

}