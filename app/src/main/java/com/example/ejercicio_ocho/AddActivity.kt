package com.example.ejercicio_ocho

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun save(v: View){
        val name = findViewById<EditText>(R.id.txtName)
        val phoneNumber = findViewById<EditText>(R.id.txtPhoneNomber)
        val contact = Contact(0, name.text.toString(), phoneNumber.text.toString())

        val db = Room.databaseBuilder(this,
            AppDatabase::class.java, "contactDB").allowMainThreadQueries().build()
        db.contactDao().insert(contact)

        Toast.makeText(this, "Save", Toast.LENGTH_LONG).show()
        finish()
    }

    fun cancel(v: View){
        finish()
    }
}