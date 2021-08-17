package com.demirli.a24quizappexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demirli.a24quizappexample.R
import com.demirli.a24quizappexample.model.Question
import com.demirli.a24quizappexample.util.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val question1 = Question(
            "Fatih Sultan Mehmet’in babası kimdir?",
            "Yıldırım Beyazıt",
            "II. Murat",
            "I. Mehmet",
            "B"
        )
        val question2 = Question(
            "Hangisi periyodik tabloda bulunan bir element değildir?",
            "Azot",
            "Oksijen",
            "Su",
            "C"
        )
        val question3 = Question(
            "Hangisi tarihteki Türk devletlerinden biri değildir?",
            "Hun İmparatorluğu",
            "Avar Kağanlığı",
            "Emevi Devleti",
            "C"
        )

        val questionList = arrayListOf(question1 ,question2, question3)

        start_btn.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            intent.putParcelableArrayListExtra(Constants.EXTRA_QUESTIONLIST,questionList)
            startActivity(intent)
        }
    }
}
