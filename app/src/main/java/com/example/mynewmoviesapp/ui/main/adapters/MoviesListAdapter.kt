package com.example.mynewmoviesapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.FragmentMainRecyclerItemBinding
import com.example.mynewmoviesapp.model.entites.Movie
import com.example.mynewmoviesapp.ui.main.moviesList.MoviesListFragment

class MoviesListAdapter(private var itemClickListener: MoviesListFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<MoviesListAdapter.MainViewHolder>() {

    private var moviesData: List<Movie> = listOf()
    private lateinit var binding: FragmentMainRecyclerItemBinding

    fun setMovies(data: List<Movie>) {
        moviesData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        binding = FragmentMainRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(moviesData[position])
    }

    override fun getItemCount() = moviesData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) = with(binding) {
            itemMovieTitle.text = movie.title
            itemMoviePoster.setImageResource(R.drawable.no_img)
            itemContainer.setOnClickListener {
                itemClickListener?.inItemViewClick(movie)
            }
        }
    }
}