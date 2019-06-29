package hands.android.webmotors.mvvm.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import hands.android.webmotors.mvvm.room.example.Example
import hands.android.webmotors.mvvm.room.example.ExampleDao

@Database(entities = [Example::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}