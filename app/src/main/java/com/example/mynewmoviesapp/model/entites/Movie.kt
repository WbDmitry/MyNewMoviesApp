package com.example.mynewmoviesapp.model.entites

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val overview: String?,
    val poster_path: String?
) : Parcelable
