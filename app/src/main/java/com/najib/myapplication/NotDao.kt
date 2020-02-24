package com.najib.myapplication
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

interface NoteDao {
    @Query(value = "SELECT * from note")
    fun getAllNote(): List<NoteModel>

    @Insert(onConflict = REPLACE)
    fun insertNote(noteModel: NoteModel)

    @Delete
    fun deleteNote(noteModel: NoteModel)

    @Query("UPDATE note Set title=:noteTitle, message =:noteMessage WHERE id =:noteId")
    fun updateNote(noteTitle: String, noteMessage: String, noteId: Long)
}