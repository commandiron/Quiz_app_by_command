package com.demirli.a24quizappexample.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.demirli.a24quizappexample.R
import com.demirli.a24quizappexample.model.Question
import com.demirli.a24quizappexample.util.Constants
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var i = 0

    private var result = ""
    private var correctAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        intent.extras.let {
            val questionList: ArrayList<Question> = intent.extras?.getParcelableArrayList<Question>(Constants.EXTRA_QUESTIONLIST) as ArrayList<Question>
            setUi(questionList[i])
            i++

            next_btn.setOnClickListener {
                optiona_btn.isClickable = true
                optionb_btn.isClickable = true
                optionc_btn.isClickable = true
                optiona_btn.setBackgroundColor(ResourcesCompat.getColor(resources,R.color.colorPrimary,null))
                optionb_btn.setBackgroundColor(ResourcesCompat.getColor(resources,R.color.colorPrimary,null))
                optionc_btn.setBackgroundColor(ResourcesCompat.getColor(resources,R.color.colorPrimary,null))

                if (i < questionList.size){
                    setUi(questionList[i])
                    i++
                }else{
                    val intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra(Constants.EXTRA_CORRECTANSWER,correctAnswer)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    fun setUi(question: Question){
        question_tv.setText(question.question)
        optiona_btn.setText(question.optionA)
        optionb_btn.setText(question.optionB)
        optionc_btn.setText(question.optionC)

        optiona_btn.setOnClickListener {
            optiona_btn.setBackgroundColor(Color.GRAY)
            result = "A"
            toastForAnswer(question, optiona_btn)
            optionb_btn.isClickable = false
            optionc_btn.isClickable = false
        }
        optionb_btn.setOnClickListener {
            optionb_btn.setBackgroundColor(Color.GRAY)
            result = "B"
            toastForAnswer(question, optionb_btn)
            optiona_btn.isClickable = false
            optionc_btn.isClickable = false
        }
        optionc_btn.setOnClickListener {
            optionc_btn.setBackgroundColor(Color.GRAY)
            result = "C"
            toastForAnswer(question, optionc_btn)
            optiona_btn.isClickable = false
            optionb_btn.isClickable = false
        }

    }

    fun toastForAnswer(question: Question, button: Button){
        if (result == question.answer){
            Toast.makeText(this,"Doğru Cevap",Toast.LENGTH_SHORT).show()
            button.setBackgroundColor(Color.GREEN)
            correctAnswer++
        }else if(result != question.answer && result != ""){
            Toast.makeText(this,"Yanlış Cevap",Toast.LENGTH_SHORT).show()
            button.setBackgroundColor(Color.RED)
        }
    }
}
