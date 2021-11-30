package com.bignerdranch.android.thirdquaterhw.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(SingleStateStrategy::class)
interface MainView : MvpView