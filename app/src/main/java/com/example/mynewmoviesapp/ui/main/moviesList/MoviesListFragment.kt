package com.example.mynewmoviesapp.ui.main.moviesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.MoviesListFragmentBinding
import com.example.mynewmoviesapp.model.AppState
import com.example.mynewmoviesapp.model.entites.Actors
import com.example.mynewmoviesapp.ui.main.adapters.MoviesListAdapter
import com.example.mynewmoviesapp.ui.main.movieInfo.MovieInfoFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.movies_list_fragment.*

class MoviesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            MoviesListFragment()
    }

    private lateinit var binding: MoviesListFragmentBinding
    private lateinit var viewModel: MoviesListViewModel

    private val onListItemClickListener = object : OnItemViewClickListener {
        override fun inItemViewClick(actors: Actors) {
            activity?.supportFragmentManager?.let {
                val bundle = Bundle()
                bundle.putParcelable(MovieInfoFragment.BUNDLE_EXTRA, actors)
                it.beginTransaction()
                    .add(R.id.container, MovieInfoFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    }

    private var adapter = MoviesListAdapter(onListItemClickListener)
    private var isDataSetCategoryOne: Boolean = true


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
        binding.mainFragmentFAB.setOnClickListener { changeCategoryDataSet() }
        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getMoviesFromLocalStorageCategoryOne()
    }

    private fun changeCategoryDataSet() {
        if (isDataSetCategoryOne) {
            viewModel.getMoviesFromLocalStorageCategoryTwo()
        } else {
            viewModel.getMoviesFromLocalStorageCategoryOne()
        }
        isDataSetCategoryOne = !isDataSetCategoryOne
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                adapter = MoviesListAdapter(object : OnItemViewClickListener {
                    override fun inItemViewClick(actors: Actors) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(MovieInfoFragment.BUNDLE_EXTRA, actors)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, MovieInfoFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply { setActors(appState.actors) }
                mainFragmentRecyclerView.adapter = adapter
            }
            is AppState.Loading -> {
                mainFragmentLoadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                Snackbar
                    .make(
                        binding.mainFragmentFAB,
                        getString(R.string.error),
                        Snackbar.LENGTH_INDEFINITE
                    )
                    .setAction(getString(R.string.reload)) { viewModel.getMoviesFromLocalStorageCategoryOne() }
                    .show()
            }
        }
    }

    interface OnItemViewClickListener {
        fun inItemViewClick(actors: Actors)
    }


}
