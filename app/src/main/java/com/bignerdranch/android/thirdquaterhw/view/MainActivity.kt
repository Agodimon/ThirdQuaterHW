package com.bignerdranch.android.thirdquaterhw.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bignerdranch.android.thirdquaterhw.R
import com.bignerdranch.android.thirdquaterhw.databinding.ActivityMainBinding
import com.bignerdranch.android.thirdquaterhw.presenter.MainPresenter
import com.bignerdranch.android.thirdquaterhw.utils.Numbers

class MainActivity : AppCompatActivity(R.layout.activity_main), MainView {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setButtonClickListener()
    }


    private fun setButtonClickListener() = with(binding) {
        buttonCounter1.setOnClickListener {
            presenter.counterClick(Numbers.ONE)
        }

        buttonCounter2.setOnClickListener {
            presenter.counterClick(Numbers.TWO)
        }

        buttonCounter3.setOnClickListener {
            presenter.counterClick(Numbers.THREE)
        }
    }

    override fun setButton1Text(text: String) = with(binding) {
        buttonCounter1.text = text
    }

    override fun setButton2Text(text: String) = with(binding) {
        buttonCounter2.text = text
    }

    override fun setButton3Text(text: String) = with(binding) {
        buttonCounter3.text = text
    }

}
