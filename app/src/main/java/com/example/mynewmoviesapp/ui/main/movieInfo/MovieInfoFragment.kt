package com.example.mynewmoviesapp.ui.main.movieInfo

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.MovieInfoFragmentBinding
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.entites.Actors
import com.example.mynewmoviesapp.ui.main.moviesList.MoviesListFragment
import com.google.android.material.snackbar.Snackbar

class MovieInfoFragment : Fragment() {

    companion object {
        fun newInstance() = MovieInfoFragment()
    }

    private lateinit var viewModel: MovieInfoViewModel
    private var _binding: MovieInfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MovieInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieInfoViewModel::class.java)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getMovies()

        init()
    }

    private fun init() = with(binding) {
        val manager = activity?.supportFragmentManager
        back.setOnClickListener {
            manager?.beginTransaction()
                ?.replace(R.id.container, MoviesListFragment.newInstance())
                ?.commitNow()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                loadingLayout.visibility = View.GONE
                setData(appState.actors)
            }
            is AppState.Loading -> {
                loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                loadingLayout.visibility = View.GONE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getMovies() }
                    .show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(actors: Actors) = with(binding) {
        moviePoster.setImageResource(R.drawable.image_movie)
        movieTitle.text = actors.movie.title
        movieDescription.text = actors.movie.description
        actor.text = actors.name + " " + actors.surname
    }

}