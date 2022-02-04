package com.example.notes


import android.app.Application
import com.example.notes.data.NotesRoomDatabase


class NotesApplication : Application() {
    // Using by lazy so the database is only created when needed
    // rather than when the application starts
    val database: NotesRoomDatabase by lazy { NotesRoomDatabase.getDatabase(this) }
}
