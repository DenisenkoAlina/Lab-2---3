package com.example.lab2.lab3_RecycleView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lab2.Person
import com.example.lab2.R
import kotlinx.android.synthetic.main.card_item.view.*

class MyAdapter(private var list: MutableList<Person>) : RecyclerView.Adapter<MyAdapter.PersonViewHolder>() {

    // Викликається, коли наш ViewHolder слід почати
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        val v: View = LayoutInflater.from(viewGroup.context) // Вказуємо і заповнюємо макет для кожного елемента RecycleView
            .inflate(R.layout.card_item, viewGroup, false)
        return PersonViewHolder(v) //Передаємо макет в конструктор ViewHolder
    }

    override fun getItemCount() = list.size // Поверне кількість елементів, присутніх в даних

    // Встановлюємо значення текстових полів та ресурс зображення
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.state.text = "State: " + list[position].state
        holder.year.text = "Year of birth: " + list[position].year
        holder.about.text = list[position].about
        holder.image.setImageResource(list[position].avatarId)

        holder.constrain.setOnClickListener { // Перехід на інший Activity
            val intent = Intent(holder.constrain.context, OnePeople::class.java)

            // Вказуємо першим параметром ключ, а другим значення по ключу, яке будемо отримувати з Intent
            intent.putExtra("position", position)
            intent.putParcelableArrayListExtra("list", ArrayList(list))

            holder.constrain.context.startActivity(intent) //Відкриваємо нове Activity
        }
    }

    // Цей патерн зводить до мінімуму кількість звернень до View
    class PersonViewHolder(@NonNull itemView: View) : ViewHolder(itemView) {
        var image: ImageView = itemView.imageView
        var name: TextView = itemView.fio
        var state: TextView = itemView.state
        var year: TextView = itemView.year
        var about: TextView = itemView.textView
        var constrain: ConstraintLayout = itemView.constrain
    }
}
