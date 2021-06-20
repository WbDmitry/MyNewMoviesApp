package com.example.mynewmoviesapp.model.entites

import com.example.mynewmoviesapp.R

data class Actors(
    val movie: Movie = getDefaultMovie(),
    val name: String = "Вин",
    val surname: String ="Дизель"
)

fun getDefaultMovie() = Movie(
    R.drawable.image_movie,
    "Форсаж",
    "Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")

