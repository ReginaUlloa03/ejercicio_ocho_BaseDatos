package com.example.ejercicio_ocho

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    lateinit var rcv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rcv = findViewById(R.id.rvContact)

    }

    override fun onResume() {
        super.onResume()

        ProvicionalData.listContact.clear()
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "contactDB")
            .allowMainThreadQueries().build()
        val consult = db.contactDao().getAll()

        consult.forEach { contact -> ProvicionalData.listContact.add(contact) }

        Log.w("Contact", "Hay ${ProvicionalData.listContact.size} register contact")
        rcv.adapter = Adapter(this)
        rcv.layoutManager = LinearLayoutManager(this)
    }

    fun btnAdd(v: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    fun clickItem(position: Int) {
        val intent = Intent(this, EditActivity::class.java)
        intent.putExtra("position", position)
        startActivity(intent)
    }

}