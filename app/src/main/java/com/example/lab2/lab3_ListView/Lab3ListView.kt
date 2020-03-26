package com.example.lab2.lab3_ListView

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.MainActivity
import com.example.lab2.Person
import com.example.lab2.R
import kotlinx.android.synthetic.main.activity_lab3_list_view.*

class Lab3ListView : AppCompatActivity() {

    private var people: MutableList<Person> = ArrayList() // Створення і заповнення об'єктів классу People

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_list_view)
        title = "Lab3 ListView"

        //Генеруємо данні
        val list: ListView = list_view // Віджет ListView
        people.add(Person(R.drawable.bill_gates, "William Henry Gates III", "male", 1955, "Is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation. During his career at Microsoft, Gates held the positions of chairman, chief executive officer (CEO), president and chief software architect, while also being the largest individual shareholder until May 2014. He is one of the best-known entrepreneurs and pioneers of the microcomputer revolution of the 1970s and 1980s."))
        people.add(Person(R.drawable.steve_jobs, "Steven Paul Jobs", "male", 1955, "Was an American business magnate, industrial designer, investor, and media proprietor. He was the chairman, chief executive officer (CEO), and co-founder of Apple Inc., the chairman and majority shareholder of Pixar, a member of The Walt Disney Company's board of directors following its acquisition of Pixar, and the founder, chairman, and CEO of NeXT. Jobs is widely recognized as a pioneer of the personal computer revolution of the 1970s and 1980s, along with Apple co-founder Steve Wozniak."))
        people.add(Person(R.drawable.mark_zuckerberg, "Mark Elliot Zuckerberg", "male", 1984, "is an American internet entrepreneur and philanthropist. He is known for co-founding Facebook, Inc. and serves as its chairman, chief executive officer, and controlling shareholder."))

        val myAdapter = MyAdapter(this, people) // Створюємо об'єкт адаптера
        list.adapter = myAdapter // Передаємо його до віджету списку

        // Кнопка BACK
        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        // Кнопка CLEAR
        clear.setOnClickListener {
            people.clear()
            myAdapter.notifyDataSetChanged()
        }
    }
}
