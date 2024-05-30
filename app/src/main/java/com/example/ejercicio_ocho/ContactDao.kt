package com.example.ejercicio_ocho

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Insert
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

    @Update
    fun update(contact: Contact)

}