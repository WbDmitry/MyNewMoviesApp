package com.example.mynewmoviesapp.model.entites

import android.os.Parcelable
import com.example.mynewmoviesapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actors(
    val movie: Movie = getDefaultMovie(),
    val name: String = "Вин",
    val surname: String = "Дизель"
) : Parcelable

fun getDefaultMovie() = Movie(
    R.drawable.image_movie,
    "Форсаж",
    "Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
)

fun getCategoryOne() = listOf(
    Actors(Movie(R.drawable.image_movie_2, "Форсаж 1", "Описание 2"), "Vin", "Dizel"),
    Actors(Movie(R.drawable.image_movie_3, "Форсаж 2", "Описание 3")),
    Actors(Movie(R.drawable.image_movie_4, "Форсаж 3", "Описание 4")),
    Actors(Movie(R.drawable.image_movie_5, "Форсаж 4", "Описание 5")),
    Actors(Movie(R.drawable.image_movie_6, "Форсаж 5", "Описание 6")),
    Actors(Movie(R.drawable.image_movie_7, "Форсаж 6", "Описание 7")),
    Actors(Movie(R.drawable.image_movie_8, "Форсаж 8", "Описание 8")),
)

fun getCategoryTwo() = listOf(
    Actors(
        Movie(
            R.drawable.image_movie,
            "Форсаж 10",
            "Описание 1. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_2,
            "Форсаж 20",
            "Описание 2. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_3,
            "Форсаж 30",
            "Описание 3. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_4,
            "Форсаж 40",
            "Описание 4. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_5,
            "Форсаж 50",
            "Описание 5. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_6,
            "Форсаж 60",
            "Описание 6. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_7,
            "Форсаж 70",
            "Описание 7. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    ),
    Actors(
        Movie(
            R.drawable.image_movie_8,
            "Форсаж 80",
            "Описание 8. Коп под прикрытием внедряется в банду стритрейсеров и становится одним из них. Первая часть гоночной франшизы"
        )
    )
)