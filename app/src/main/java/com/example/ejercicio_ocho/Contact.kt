package com.example.ejercicio_ocho

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo() val name: String,
    @ColumnInfo() val phone: String
)
