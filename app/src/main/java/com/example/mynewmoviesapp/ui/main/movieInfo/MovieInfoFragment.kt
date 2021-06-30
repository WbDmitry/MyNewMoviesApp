package com.example.mynewmoviesapp.ui.main.movieInfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynewmoviesapp.databinding.MovieInfoFragmentBinding
import com.example.mynewmoviesapp.model.entites.Actors

class MovieInfoFragment : Fragment() {
    private var _binding: MovieInfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MovieInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
            arguments?.getParcelable<Actors>(BUNDLE_EXTRA)?.let {
            val movie = it.movie
            val name = it.name
            val surname = it.surname
            movieTitle.text = movie.title
            movieDescription.text = movie.description
            moviePoster.setImageResource(movie.poster)
            actorName.text = "$name $surname"

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_EXTRA = "actors"

        fun newInstance(bundle: Bundle):MovieInfoFragment {
            val fragment = MovieInfoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}