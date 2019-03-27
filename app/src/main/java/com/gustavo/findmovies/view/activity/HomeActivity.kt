package com.gustavo.findmovies.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crosoften.findmovies.R
import com.gustavo.findmovies.data.entity.Movie
import com.gustavo.findmovies.view.adapter.MovieHomeAdapter
import com.gustavo.findmovies.view.interfaces.OnClickListener
import com.gustavo.findmovies.view.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*


class HomeActivity : AppCompatActivity(),
    OnClickListener {
    override fun onMovieClicked(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("ID_MOVIE", movie.imdbID)
        startActivity(intent)
    }

    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        float_add_movie.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        loadMovies()
    }

    private fun loadMovies() {
        viewModel = ViewModelProviders.of(this@HomeActivity)[MovieViewModel::class.java]
        viewModel.allMovies.observe(this, Observer {
            if (it != null) {

                picker.adapter = MovieHomeAdapter(this, it, this)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        loadMovies()
    }
}
