package com.example.ejercicio_ocho

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class EditActivity : AppCompatActivity() {

    var position: Int = 0
    lateinit var txtName: EditText
    lateinit var btnDelete: Button
    lateinit var txtPhoneNumber: EditText
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        btnDelete = findViewById(R.id.btnCancel)

        "Eliminar".also { btnDelete.text = it }
        "Modificar Contacto".also { txtTitle.text = it }

        position = intent.getIntExtra("position", -1)
        Log.e("Contact", "Se recibio un ${position}")
        txtName = findViewById(R.id.txtName)
        txtPhoneNumber = findViewById(R.id.txtPhoneNomber)

        val contact = ProvicionalData.listContact[position]
        id = contact.id

        txtName.setText(contact.name)
        txtPhoneNumber.setText(contact.phone)

    }
    fun save(v: View) {
        val contact = Contact(id, txtName.text.toString(), txtPhoneNumber.text.toString())
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "contactDB").allowMainThreadQueries().build()
        db.contactDao().update(contact)

        Toast.makeText(this, "Se modifico", Toast.LENGTH_LONG).show()
        finish()
    }

    fun cancel(v: View) {
        val contact = Contact(id, txtName.text.toString(), txtPhoneNumber.text.toString())
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "contactDB").allowMainThreadQueries().build()
        db.contactDao().delete(contact)

        Toast.makeText(this, "Se elimino", Toast.LENGTH_LONG).show()
        finish()
    }

}