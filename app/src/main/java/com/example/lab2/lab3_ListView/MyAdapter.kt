package com.example.lab2.lab3_ListView

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lab2.Person
import com.example.lab2.R
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(context: Context, private var data: MutableList<Person>) : BaseAdapter() {

    //об'єкт LayoutInflater, який буде використовуватись для отримання дерева об'єктів UI з макета.
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    // Метод повертає корінь дерева об'єктів UI, які відображають пункт списку
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        // Перетворюємо макет в дерево об'єктів
        val view: View = inflater.inflate(R.layout.list_item, parent, false)

        // Отримуємо доступ до віджетів дерева об'єктів
        val number = view.number
        val image = view.imageView
        val name = view.fio
        val state = view.state
        val year = view.year
        val about = view.textView
        val button = view.press

        // міняємо зміст віджетів
        number.text = (position + 1).toString()
        image.setImageResource(data[position].avatarId)
        name.text = data[position].name
        state.text = "State: " + data[position].state
        year.text = "Year of birth: " + data[position].year.toString()
        about.text = data[position].about

        button.setOnClickListener { // Перехід на інший Activity
            val intent = Intent(button.context, OnePeople::class.java)

            // Вказуємо першим параметром ключ, а другим значення по ключу, яке будемо отримувати з Intent
            intent.putExtra("position", position)
            intent.putParcelableArrayListExtra("list", ArrayList(data))

            button.context.startActivity(intent) //Відкриваємо нове Activity
        }
        // Повертає модификоване дерево об'єктів
        return view
    }

    // Отримання елемента даних, пов’язаний із вказаною позицією в наборі даних.
    override fun getItem(position: Int): Any? = data[position]
    // Отримання ідентифікатора рядка, пов’язаний із вказаною позицією у списку.
    override fun getItemId(position: Int): Long = position.toLong()
    // Отримання кількості елементів у наборі даних, представленому цим адаптером.
    override fun getCount(): Int = data.size
}