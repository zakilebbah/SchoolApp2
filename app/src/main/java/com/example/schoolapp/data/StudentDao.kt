package com.example.schoolapp.data




import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getAll(): Flow<List<Student>>

    @Query("SELECT * FROM Student WHERE sid ==:sid")
    fun loadById(sid: Int): Student

    @Query("SELECT * FROM Student WHERE nom LIKE :name0 OR prenom LIKE :name0")
    fun findName(name0: String): Student

    @Insert
    fun insertStudent(student: Student)
    @Update(entity = Student::class)
    fun update(student: Student)
    @Delete
    fun delete(student: Student)

    @Query("DELETE FROM Student")
    fun deleteAll()
}