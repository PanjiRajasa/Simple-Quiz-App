package com.example.simplequizapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplequizapp.R
import com.example.simplequizapp.model.Question
import com.example.simplequizapp.utils.Constant

class QuestionActivity : AppCompatActivity() {
//    lateinit var declaration
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

//    lateinit var options
    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

//    default current position
    private val currentPosition = 1
//    question list variable
    private lateinit var questionList: MutableList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        variable declaration
         questionList = Constant.getQuestion()

//        printed to the logcat
        Log.d("question size", "${questionList.size}")

//        find the id
        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.progress_text_view)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.flag_image)

//        options id
        textViewOptionOne = findViewById(R.id.optionOne_text_view)
        textViewOptionTwo = findViewById(R.id.optionTwo_text_view)
        textViewOptionThree = findViewById(R.id.optionThree_text_view)
        textViewOptionFour = findViewById(R.id.optionFour_text_view)

//        call the function
        setQuestion()
    }

//    set the question
    private fun setQuestion() {
//        remember, to access a list, also use the bracket notation just like how you access an array
//        question 1 -> id 1, but in array it actually 0 (array starts from 0 index)
//        look closely! 1-1 = 0 => n - 1. another example 2 (id) - 1 = 1 => second index
        val question = questionList[currentPosition - 1]

//      each variables == variables that linked to the currentPosition, progressBar.max, and question's property
        flagImage.setImageResource(question.image)
        progressBar.progress = currentPosition
        textViewProgress.text = getString(R.string.text_view_progress_format, currentPosition, progressBar.max)
        textViewQuestion.text = question.question

//        options
        textViewOptionOne.text = question.optionOne
        textViewOptionTwo.text = question.optionTwo
        textViewOptionThree.text = question.optionThree
        textViewOptionFour.text = question.optionFour
    }
}