package com.example.simplequizapp.model

data class Question(
    val id: Int,
    val Question: String,
    val Image: Int,
//    pilihan ganda
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)
