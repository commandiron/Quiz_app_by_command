package com.demirli.a24quizappexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demirli.a24quizappexample.R
import com.demirli.a24quizappexample.util.Constants
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val correctAnswer = intent.getIntExtra(Constants.EXTRA_CORRECTANSWER,0)

        result_tv.setText("$correctAnswer adet doğru yaptınız.")

        tryAgain_btn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}
