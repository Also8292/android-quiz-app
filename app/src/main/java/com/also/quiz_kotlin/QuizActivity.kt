package com.also.quiz_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.also.quiz_kotlin.R.id
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var quizs = ArrayList<Quiz>()
    private var numberOfGoodAnswers: Int = 0
    private var currentQuizIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizs.add(Quiz("Quelle est la capitale de l'Algérie ?", "Dakar", "Alger", "Caire", 2))
        quizs.add(Quiz("Quelle est la capitale du Rwanda ?", "Kigali", "Paris", "Bamako", 1))
        quizs.add(Quiz("Quelle est la capitale de l'Ethiopie ?", "Lagos", "Tunis", "Adis Abeba", 3))
        quizs.add(Quiz("Quelle est la capitale du Maroc ?", "Rabat", "Casablanca", "Venis", 1))
        quizs.add(Quiz("Quelle est la capitale de l'Egypte ?", "Nairobi", "Accra", "Caire", 3))

        showQuestions(this.quizs[currentQuizIndex])
    }

    private fun showQuestions(quiz: Quiz) {
        txtQuestion.text = quiz.question
        answer1.text = quiz.answer1
        answer2.text = quiz.answer2
        answer3.text = quiz.answer3

    }

    fun answer(view: View) {
        this.toast(message = "Question : " + this.currentQuizIndex)
        if (view.id == id.answer1) {
            if (this.quizs[this.currentQuizIndex].correctAnswerNumber == 1) {
                this.toast(message = "True")
                this.numberOfGoodAnswers += 1
            }
            else
                this.toast(message = "False")
        }
        else if (view.id == id.answer2) {
            if (this.quizs[this.currentQuizIndex].correctAnswerNumber == 2) {
                this.toast(message = "True")
                this.numberOfGoodAnswers += 1
            }
            else
                this.toast(message = "False")
        }
        else if (view.id == id.answer3) {
            if (this.quizs[this.currentQuizIndex].correctAnswerNumber == 3) {
                this.toast(message = "True")
                this.numberOfGoodAnswers += 1
            }
            else
                this.toast(message = "False")
        }

        this.currentQuizIndex += 1

        if (this.currentQuizIndex < this.quizs.size)
            showQuestions(this.quizs[this.currentQuizIndex])
        else
            this.toast(message = "Score : " + this.numberOfGoodAnswers)
    }

    private fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
