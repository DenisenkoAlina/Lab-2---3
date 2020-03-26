package com.example.lab2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lab2.lab3_ListView.Lab3ListView
import com.example.lab2.lab3_RecycleView.Lab3RecyclerView

class MainActivity : Activity() { // Лабораторна робота 2. Явні наміри

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Lab2-3"
    }

    fun onClick(view: View) {
        when ((view as Button).id) {
            // Лабораторна робота 3. Робота з ListView
            R.id.lab3_list_view -> startActivity(Intent(this, Lab3ListView::class.java))
            // Лабораторна робота 3. Робота з RecyclerView
            R.id.lab3_recycler_view -> startActivity(Intent(this, Lab3RecyclerView::class.java))
            // Лабораторна робота 2. Неявні наміри (Camera)
            R.id.lab2_camera -> startActivity(Intent(this, Lab2Camera::class.java))
        }
    }
}
