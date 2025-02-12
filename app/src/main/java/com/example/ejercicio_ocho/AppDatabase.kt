package com.example.ejercicio_ocho

import androidx.room.Database
import androidx.room.Insert
import androidx.room.RoomDatabase

@Database(entities = [Contact::class] , version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

}