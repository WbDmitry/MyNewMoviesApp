package com.example.mynewmoviesapp.model.entites

import android.os.Parcelable
import com.example.mynewmoviesapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actors(
    val movie: Movie = getDefaultMovie(),
    val name: String = "Вин",
    val surname: String = "Дизель"
): Parcelable

fun getDefaultMovie() = Movie(
    R.drawable.image_movie,
    "Форсаж",
    "Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
)

fun getCategoryOne(): List<Actors> {
    return listOf(
        Actors(Movie(R.drawable.image_movie, "Форсаж 2", "Описание 2")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 3", "Описание 3")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 4", "Описание 4")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 5", "Описание 5")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 6", "Описание 6")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 7", "Описание 7")),
        Actors(Movie(R.drawable.image_movie, "Форсаж 8", "Описание 8")),
    )
}

fun getCategoryTwo(): List<Actors> {
    return listOf(
        Actors(Movie(R.drawable.image_movie, "Форсаж 1", "Описание 1. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_2, "Форсаж 2", "Описание 2. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_3, "Форсаж 3", "Описание 3. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_4, "Форсаж 4", "Описание 4. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_5, "Форсаж 5", "Описание 5. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_6, "Форсаж 6", "Описание 6. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_7, "Форсаж 7", "Описание 7. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
        Actors(Movie(R.drawable.image_movie_8, "Форсаж 8", "Описание 8. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы")),
    )
}