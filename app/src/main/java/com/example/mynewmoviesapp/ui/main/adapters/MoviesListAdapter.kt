package com.example.mynewmoviesapp.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewmoviesapp.R
import com.example.mynewmoviesapp.databinding.FragmentMainRecyclerItemBinding
import com.example.mynewmoviesapp.model.entites.Actors
import com.example.mynewmoviesapp.ui.main.moviesList.MoviesListFragment

class MoviesListAdapter(private var itemClickListener: MoviesListFragment.OnItemViewClickListener?) :
    RecyclerView.Adapter<MoviesListAdapter.MainViewHolder>() {

    private var ActorsData: List<Actors> = listOf()

    private lateinit var binding: FragmentMainRecyclerItemBinding

    fun setActors(data: List<Actors>) {
        ActorsData = data
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
        holder.bind(ActorsData[position])
    }

    override fun getItemCount() = ActorsData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(actors: Actors) = with(binding) {
            itemMovieTitle.text = actors.movie.title
            itemMoviePoster.setImageResource(actors.movie.poster)
            itemContainer.setOnClickListener {
                itemClickListener?.inItemViewClick(actors)
            }
        }
    }
}
