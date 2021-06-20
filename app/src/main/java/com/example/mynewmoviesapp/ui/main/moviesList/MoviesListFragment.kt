package com.example.mynewmoviesapp.ui.main.moviesList

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.MoviesListFragmentBinding
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.entites.Actors
import com.example.mynewmoviesapp.ui.main.movieInfo.MovieInfoFragment

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    private lateinit var viewModel: MoviesListViewModel
    private var _binding: MoviesListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MoviesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)

        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getMovies()

        initW()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initW() = with(binding) {
        containerCardList.setOnClickListener {
            val manager = activity?.supportFragmentManager
            manager
                ?.beginTransaction()
                ?.replace(R.id.container, MovieInfoFragment.newInstance())
                ?.commitNow()
        }
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
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(actors: Actors) = with(binding) {
        moviePoster.setImageResource(R.drawable.image_movie)
        movieTitle.text = actors.movie.title
        movieDescription.text = actors.movie.description
    }
}