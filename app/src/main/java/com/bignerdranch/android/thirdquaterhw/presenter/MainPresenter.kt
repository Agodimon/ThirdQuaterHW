package com.bignerdranch.android.thirdquaterhw.presenter

import com.bignerdranch.android.thirdquaterhw.model.CountersModel
import com.bignerdranch.android.thirdquaterhw.utils.Numbers
import com.bignerdranch.android.thirdquaterhw.view.MainView

class MainPresenter(val view: MainView) {
    val model = CountersModel()
    fun counterClick(buttonCounterNumber: Numbers) {
        when (buttonCounterNumber) {
            Numbers.ONE -> view.setButton1Text(model.next(0).toString())
            Numbers.TWO -> view.setButton2Text(model.next(1).toString())
            Numbers.THREE -> view.setButton3Text(model.next(2).toString())
        }
    }
}
