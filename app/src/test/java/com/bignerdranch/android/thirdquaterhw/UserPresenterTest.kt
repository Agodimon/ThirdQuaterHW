package com.bignerdranch.android.thirdquaterhw


import com.bignerdranch.android.thirdquaterhw.model.GithubUser
import com.bignerdranch.android.thirdquaterhw.presenter.UserDetailsPresenter
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.rxjava3.core.Scheduler
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class UserPresenterTest {

    private lateinit var presenter: UserDetailsPresenter

    @InjectMocks
    private lateinit var router: Router

    @Mock
    private lateinit var repository: GithubRepositoriesRepo

    @Mock
    private lateinit var scheduler: Scheduler

    @Mock
    private lateinit var user: GithubUser

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = UserPresenter(repository, router, scheduler, user)
    }

    @Test
    fun userPresenterBackClick_Test() {
        presenter.backClick()
        verify(repository, times(1))
    }

}