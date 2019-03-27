package com.gustavo.findmovies.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.crosoften.findmovies.R
import com.gustavo.findmovies.api.reponse.Movies
import com.gustavo.findmovies.view.interfaces.OnClickMovieListener
import com.squareup.picasso.Picasso

/*
*  Adapter referente a criação de um item de View para o RecyclerView de Filmes
* */

class MovieAdapter(
    var context: Context,
    var movies: List<Movies>,
    var listener: OnClickMovieListener
) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_movie_adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.titleMovie.text = movie.title
        holder.yearMovie.text = movie.year.toString()
        holder.container.setOnClickListener { listener.onMovieClicked(movie) }
        Picasso
            .get()
            .load(movie.poster)
            .into(holder.posterMovie)
    }


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var yearMovie = itemView.findViewById<TextView>(R.id.text_year_movie)
        var titleMovie = itemView.findViewById<TextView>(R.id.text_title_movie)
        var posterMovie = itemView.findViewById<ImageView>(R.id.image_poster_movie)
        var container = itemView.findViewById<ConstraintLayout>(R.id.container)
    }
}