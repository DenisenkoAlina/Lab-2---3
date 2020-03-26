package com.example.lab2.lab3_ListView

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.lab2.Person
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_one_people.*

class OnePeople : Activity() {

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_people)
        val intent = Intent(this, Lab3ListView::class.java)

        // Приймаємо дані, які ми передали
        val position: Int = getIntent().getIntExtra("position", 0)
        val list = getIntent().getParcelableArrayListExtra<Person>("list")

        title = list[position].name
        //Встановлюємо дані в activity_one_people
        imageView.setImageResource(list[position].avatarId)
        fioText.text = list[position].name
        stateText.text = "State: " + list[position].state
        yearText.text = "Year of birth: " + list[position].year.toString()
        textView.text = list[position].about

        // Кнопка BACK
        back.setOnClickListener {
            startActivity(intent)
        }
    }
}
