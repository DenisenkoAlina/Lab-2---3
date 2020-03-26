package com.example.lab2.lab3_RecycleView

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.MainActivity
import com.example.lab2.Person
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_lab3_recycler_view.*

class Lab3RecyclerView : Activity() {

    private lateinit var recyclerView: RecyclerView //Змінна посилання на об'єкт RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*> //Змінна адаптера
    private lateinit var viewManager: RecyclerView.LayoutManager //Змінна менеджера компонування

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_recycler_view)
        title = "Lab3 RecyclerView"

        val people: MutableList<Person> = ArrayList() // Створення і заповнення об'єктів классу People
        people.add(Person(R.drawable.bill_gates, "William Henry Gates III", "male", 1955, "Is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation. During his career at Microsoft, Gates held the positions of chairman, chief executive officer (CEO), president and chief software architect, while also being the largest individual shareholder until May 2014. He is one of the best-known entrepreneurs and pioneers of the microcomputer revolution of the 1970s and 1980s."))
        people.add(Person(R.drawable.steve_jobs, "Steven Paul Jobs", "male", 1955, "Was an American business magnate, industrial designer, investor, and media proprietor. He was the chairman, chief executive officer (CEO), and co-founder of Apple Inc., the chairman and majority shareholder of Pixar, a member of The Walt Disney Company's board of directors following its acquisition of Pixar, and the founder, chairman, and CEO of NeXT. Jobs is widely recognized as a pioneer of the personal computer revolution of the 1970s and 1980s, along with Apple co-founder Steve Wozniak."))
        people.add(Person(R.drawable.mark_zuckerberg, "Mark Elliot Zuckerberg", "male", 1984, "is an American internet entrepreneur and philanthropist. He is known for co-founding Facebook, Inc. and serves as its chairman, chief executive officer, and controlling shareholder."))

        // Менеджер компонування для управління позиціонуванням своїх елементів
        viewManager = LinearLayoutManager(this)
        //Адаптер для доступу до даних
        viewAdapter = MyAdapter(people)
        // Посилання на об'єкт RecyclerView
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            setHasFixedSize(true) // Розмір RecyclerView не буде змінюватись
            layoutManager = viewManager
            adapter = viewAdapter
        }

        // Кнопка BACK
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        // Кнопка CLEAR
        clear.setOnClickListener {
            people.clear()
            viewAdapter.notifyDataSetChanged()
        }
    }
}
