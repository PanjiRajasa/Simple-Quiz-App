package com.example.simplequizapp.utils

import com.example.simplequizapp.R
import com.example.simplequizapp.model.Question

object Constant {
    fun getQuestion(): MutableList<Question> {
        val questions = mutableListOf<Question>()

//        declare questions and add it to the questions
        val question1 = Question(
            1, "What country does this flag belong?",
            R.drawable.palestine,
            "Palestine",
            "Africa",
            "Philippine",
            "Yaman",
            1
        )

//        add to the mutableListOf
        questions.add(question1)


//        declare questions and add it to the questions
        val question2 = Question(
            2, "What country does this flag belong?",
            R.drawable.iraq,
            "Indonesia",
            "Iraq",
            "Malaysia",
            "Chinese",
            2
        )

//        add to the mutableListOf
        questions.add(question2)


        //        declare questions and add it to the questions
        val question3 = Question(
            3, "What country does this flag belong?",
            R.drawable.egypt,
            "Indonesia",
            "England",
            "Egypt",
            "Japanese",
            3
        )

//        add to the mutableListOf
        questions.add(question3)


        //        declare questions and add it to the questions
        val question4 = Question(
            4, "What country does this flag belong?",
            R.drawable.yaman,
            "South Korea",
            "Morocco",
            "Cambodia",
            "Yaman",
            4
        )

//        add to the mutableListOf
        questions.add(question4)


        //        declare questions and add it to the questions
        val question5 = Question(
            5, "What country does this flag belong?",
            R.drawable.chinese,
            "Indonesia",
            "Russia",
            "Malaysia",
            "Chinese",
            4
        )

//        add to the mutableListOf
        questions.add(question5)


        //        declare questions and add it to the questions
        val question6 = Question(
            6, "What country does this flag belong?",
            R.drawable.afganistan,
            "Afghanistan",
            "Iraq",
            "Malaysia",
            "Chinese",
            1
        )

//        add to the mutableListOf
        questions.add(question6)


        //        declare questions and add it to the questions
        val question7 = Question(
            7, "What country does this flag belong?",
            R.drawable.findland,
            "Canada",
            "Brazil",
            "Finland",
            "Swiss",
            3
        )

//        add to the mutableListOf
        questions.add(question7)


        //        declare questions and add it to the questions
        val question8 = Question(
            8, "What country does this flag belong?",
            R.drawable.indonesia,
            "Indonesia",
            "Australia",
            "Ghana",
            "Hawaii",
            1
        )

//        add to the mutableListOf
        questions.add(question8)


        //        declare questions and add it to the questions
        val question9 = Question(
            9, "What country does this flag belong?",
            R.drawable.japanese,
            "US",
            "Japan",
            "Thailand",
            "Timor Leste",
            2
        )

//        add to the mutableListOf
        questions.add(question9)


        //        declare questions and add it to the questions
        val question10 = Question(
            10, "What country does this flag belong?",
            R.drawable.malaysia,
            "Spain",
            "Italy",
            "Malaysia",
            "Vietnam",
            3
        )

//        add to the mutableListOf
        questions.add(question10)

//        return the list
        return questions
    }

}