package com.example.mynewmoviesapp.ui.main.moviesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.MoviesListFragmentBinding
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.entites.Movie
import com.example.mynewmoviesapp.ui.main.adapters.MoviesListAdapter
import com.example.mynewmoviesapp.ui.main.movieInfo.MovieInfoFragment
import com.google.android.material.snackbar.Snackbar

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            MoviesListFragment()
    }

    private lateinit var binding: MoviesListFragmentBinding
    private lateinit var viewModel: MoviesListViewModel

    private val onListItemClickListener = object : OnItemViewClickListener {
        override fun inItemViewClick(movie: Movie) {
            activity?.supportFragmentManager?.let {
                val bundle = Bundle()
                bundle.putParcelable(MovieInfoFragment.BUNDLE_EXTRA, movie)
                it.beginTransaction()
                    .add(R.id.container, MovieInfoFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    }

    private var adapter = MoviesListAdapter(onListItemClickListener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MoviesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainFragmentRecyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getData()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                adapter = MoviesListAdapter(object : OnItemViewClickListener {
                    override fun inItemViewClick(movie: Movie) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(MovieInfoFragment.BUNDLE_EXTRA, movie)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, MovieInfoFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply { setMovies(appState.movie) }
                mainFragmentRecyclerView.adapter = adapter
            }
            is AppState.Loading -> {
                mainFragmentLoadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                appState.error.localizedMessage?.let {
                    mainFragmentRecyclerView.showErrorSnackBar(
                        it,
                        getString(R.string.reload))
                }
            }
        }
    }

    private fun View.showErrorSnackBar(text: String, actionText: String, length: Int = Snackbar.LENGTH_INDEFINITE) {
        Snackbar.make(this, text, length)
            .setAction(actionText) { viewModel.getData() }
            .show()
    }

    interface OnItemViewClickListener {
        fun inItemViewClick(movie: Movie)
    }
}