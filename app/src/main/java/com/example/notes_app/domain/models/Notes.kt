package com.example.notes_app.domain.models

import com.google.gson.annotations.SerializedName


data class Notes(
    @SerializedName("title")
    val noteTitle: String? = null,

    @SerializedName("content")
    val noteDescription: String? = null,

    val notePriority: String? = null,


)