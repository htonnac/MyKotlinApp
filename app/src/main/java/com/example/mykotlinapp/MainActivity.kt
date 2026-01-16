package com.example.mykotlinapp

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.random.Random

class MainActivity : Activity() {
    private lateinit var randomNumberText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }

        randomNumberText = TextView(this).apply {
            text = generateRandomNumber().toString()
            textSize = 64f
            gravity = Gravity.CENTER
        }

        val generateButton = Button(this).apply {
            text = "Generate New Number"
            setOnClickListener {
                randomNumberText.text = generateRandomNumber().toString()
            }
        }

        layout.addView(randomNumberText)
        layout.addView(generateButton)

        setContentView(layout)
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(1, 11)
    }
}
