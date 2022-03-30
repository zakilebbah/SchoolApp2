package com.example.schoolapp

import android.app.Application
import com.example.schoolapp.data.AppDatabase
import com.example.schoolapp.data.ClasseRepository
import com.example.schoolapp.data.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainApp : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
    val repositoryClasse by lazy { ClasseRepository(database.classeDao()) }
    val repositoryStudent by lazy { StudentRepository(database.studentDao()) }
}