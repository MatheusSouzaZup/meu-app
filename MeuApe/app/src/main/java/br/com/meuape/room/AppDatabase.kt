package br.com.meuape.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.meuape.room.example.Example
import br.com.meuape.room.example.ExampleDao

@Database(entities = [Example::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}