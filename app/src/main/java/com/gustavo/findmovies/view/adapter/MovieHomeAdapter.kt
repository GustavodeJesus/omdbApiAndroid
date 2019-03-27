package com.gustavo.findmovies.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crosoften.findmovies.R
import com.google.android.material.card.MaterialCardView
import com.gustavo.findmovies.data.entity.Movie
import com.gustavo.findmovies.view.interfaces.OnClickListener
import com.squareup.picasso.Picasso

class MovieHomeAdapter(
    var context: Context,
    var movies: List<Movie>,
    var listener: OnClickListener
) :
    RecyclerView.Adapter<MovieHomeAdapter.MovieHomeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHomeViewHolder {
        return MovieHomeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_movie_home_adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieHomeViewHolder, position: Int) {
        val movie = movies[position]
        holder.nameMovie.text = movie.title
        holder.container.setOnClickListener { listener.onMovieClicked(movie) }
        Picasso
            .get()
            .load(movie.poster)
            .into(holder.posterMovie)
    }

    inner class MovieHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameMovie = itemView.findViewById<TextView>(R.id.text_name_movie)
        var posterMovie = itemView.findViewById<ImageView>(R.id.img_poster_movie)
        var container = itemView.findViewById<MaterialCardView>(R.id.container)
    }

}