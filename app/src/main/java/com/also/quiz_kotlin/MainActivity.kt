package com.also.quiz_kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onStartBtn(view: View) {
        // this.toast("Toast test")
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun onQuit(view: View) {
        this.toast("Quit")
    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
