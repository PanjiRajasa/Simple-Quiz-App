package com.example.simplequizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplequizapp.R
import com.example.simplequizapp.model.Question
import com.example.simplequizapp.utils.Constant

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
//    lateinit var declaration
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

//    check button
    private lateinit var checkButton: Button

//    lateinit var options
    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView

//    default current position
    private val currentPosition = 1
//    question list variable
    private lateinit var questionList: MutableList<Question>
//    selected option position
    private var selectedOptionPosition = 0

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
        checkButton = findViewById(R.id.button_check)

//        options id
        textViewOptionOne = findViewById(R.id.optionOne_text_view)
        textViewOptionTwo = findViewById(R.id.optionTwo_text_view)
        textViewOptionThree = findViewById(R.id.optionThree_text_view)
        textViewOptionFour = findViewById(R.id.optionFour_text_view)

//        logic when the option text get clicked
        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
//        logic when the checkButton get clicked
        checkButton.setOnClickListener(this)

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

        if(currentPosition == questionList.size) {
            checkButton.text = getString(R.string.finish_placeholder)
        } else {
            checkButton.text = getString(R.string.check_placeholder)
        }
    }

    private fun resetOption() {
//        list that used the TextView as its data type, so this list can access all of the TextView property
        val options = mutableListOf<TextView>()
//        select the options textView because they're textView too
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

//        loop through the list, here we use the textView of the options and then loop through it, this approach will avoiding us from the duplicable codes
        for (option in options) {
//            in this loop, we use the TextView property such as textColor, typeface
//            grey color
            option.setTextColor(Color.parseColor("#7A8089"))
//            typeface similar to typography
            option.typeface = Typeface.DEFAULT
//            set the background, here we'll get the drawable resource
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_background
            )
        }
    }

    private fun selectedOption(textView: TextView, selectOptionNumber: Int) {
        resetOption()

        selectedOptionPosition = selectOptionNumber

//        use the textView's properties
//        set the text color (custom grey)
        textView.setTextColor(Color.parseColor("#363A43"))
//        set the typeface
        textView.setTypeface(textView.typeface, Typeface.BOLD)
//        set the background
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_background
        )
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.optionOne_text_view -> {
                selectedOption(textViewOptionOne, 1)
            }
            R.id.optionTwo_text_view -> {
                selectedOption(textViewOptionTwo, 2)
            }
            R.id.optionThree_text_view -> {
                selectedOption(textViewOptionThree, 3)
            }
            R.id.optionFour_text_view -> {
                selectedOption(textViewOptionFour, 4)
            }
            R.id.button_check -> {
                TODO("working (2)")
            }
        }
    }
}