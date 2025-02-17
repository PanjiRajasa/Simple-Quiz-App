package com.example.simplequizapp.utils

import com.example.simplequizapp.R
import com.example.simplequizapp.model.Question

object Constant {
    fun getQuestion(): MutableList<Question> {
        val questions = mutableListOf<Question>()
        val question1 = Question(
            1, "What country does this flag belong?",
            R.drawable.palestine,
            "Palestine",
            "Africa",
            "Philippine",
            "Yamen",
            1
        )
        questions.add(question1)
    }

}