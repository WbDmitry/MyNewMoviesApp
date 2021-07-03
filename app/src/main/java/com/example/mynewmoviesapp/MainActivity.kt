package com.example.mynewmoviesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mynewmoviesapp.databinding.ActivityMainBinding
import com.example.mynewmoviesapp.ui.main.moviesList.MoviesListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesListFragment.newInstance())
                .commitNow()

    }
}