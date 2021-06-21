package com.example.mynewmoviesapp.ui.main.movieInfo

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            arguments?.getParcelable<Actors>(BUNDLE_EXTRA)?.let {
            val movie = it.movie
            binding.movieTitle.text = movie.title
            binding.movieDescription.text = movie.description
            binding.moviePoster.setImageResource(movie.poster)
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