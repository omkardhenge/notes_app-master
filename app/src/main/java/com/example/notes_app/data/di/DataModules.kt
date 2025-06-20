package com.example.notes_app.data.di

import android.util.Log
import com.appsv.notesappwithnodejs.BuildConfig
import com.example.notes_app.data.remote.NotesAPI
import com.example.notes_app.data.repository.NotesRepositoryImpl
import com.example.notes_app.domain.repository.NotesRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideNotesApi() : NotesAPI {
    Log.d("BASE_URL_CHECK","BASE_URL = ${BuildConfig.BASE_URL}")
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesAPI::class.java)
}

fun provideNotesRepository(notesAPI: NotesAPI) : NotesRepository{
    return NotesRepositoryImpl(notesAPI)
}
val dataModules = module {
    single {
        provideNotesApi()
    }
    single {
        provideNotesRepository(get())
    }
}