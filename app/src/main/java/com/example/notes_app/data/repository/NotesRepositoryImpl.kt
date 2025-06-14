package com.example.notes_app.data.repository

import android.util.Log
import com.example.notes_app.common.util.Resource
import com.example.notes_app.data.remote.NotesAPI
import com.example.notes_app.domain.models.Notes
import com.example.notes_app.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImpl(
    private val notesAPI: NotesAPI
) : NotesRepository {
    override suspend fun saveNotes(notes: Notes): Flow<Resource<String>> = flow {

        emit(Resource.Loading())



        try{
            val noteMap = mapOf(
                "title" to notes.noteTitle,
                "content" to notes.noteDescription,
                "notePriority" to notes.notePriority
            )

            val response = notesAPI.saveNotes(noteMap)
            val status = response.code()
            Log.d("SAVE_NOTES", "HTTP status: $status")

            if(status == 201){
                emit(Resource.Success("Notes Saved!"))
            }else{
                emit(Resource.Error("Unable to save notes"))
            }
        }
        catch (e:Exception){
            emit(Resource.Error(e.message!!))
        }
    }

    override suspend fun getNotes(): Flow<Resource<List<Notes>>>  = flow{
        val status = notesAPI.getNotes().code()
        try{
            val notesList = notesAPI.getNotes().body()
            if(status == 200){
                emit(Resource.Success(notesList))
            }else{
                emit(Resource.Error("Unable to save notes"))
            }
        }
        catch (e:Exception){
            emit(Resource.Error(e.message!!))
        }
    }
}