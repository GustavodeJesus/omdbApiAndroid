package com.gustavo.findmovies.view.activity

import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.crosoften.findmovies.R
import com.gustavo.findmovies.api.reponse.Movies
import com.gustavo.findmovies.data.entity.Movie
import com.gustavo.findmovies.view.adapter.MovieAdapter
import com.gustavo.findmovies.view.interfaces.OnClickMovieListener
import com.gustavo.findmovies.view.interfaces.SearchMovie
import com.gustavo.findmovies.view.util.SearchMoviePresenter
import com.gustavo.findmovies.view.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_search.*
import java.lang.Exception

class SearchActivity :
    AppCompatActivity(),
    SearchMovie.View,
    OnClickMovieListener {

    companion object {
        const val newSearchActivityRequestCode = 1
    }

    private lateinit var presenter: SearchMoviePresenter
    private lateinit var movieViewModel: MovieViewModel


    override fun showPlate() {
        Toast.makeText(this, "Trouxe Dados", Toast.LENGTH_SHORT).show()
    }

    override fun hidePlate() {
        Toast.makeText(this, "Não Trouxe Dados", Toast.LENGTH_SHORT).show()
    }

    override fun showRes(movieList: List<Movies>) {
        val adapter = MovieAdapter(this, movieList, this)
        recycler_list_movies.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        presenter = SearchMoviePresenter(this)
        movieViewModel = ViewModelProviders.of(this@SearchActivity)[MovieViewModel::class.java]

        recycler_list_movies.layoutManager = LinearLayoutManager(this)
        recycler_list_movies.setHasFixedSize(true)
        recycler_list_movies.itemAnimator = DefaultItemAnimator()
        recycler_list_movies.isNestedScrollingEnabled = false

        edit_text_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isEmpty() && s.toString().length < 3) {
                    presenter.onNoSearchParam()
                } else {
                    presenter.onSearchParam(s.toString())
                }
            }

        })
    }

    override fun onMovieClicked(movies: Movies) {
        Toast.makeText(this, movies.title, Toast.LENGTH_SHORT).show()
        val movie = Movie(
            title = movies.title,
            imdbID = movies.imdbID,
            poster = movies.poster,
            type = movies.type,
            year = movies.year
        )

        try {
            movieViewModel.insert(movie)
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(
                this@SearchActivity,
                "Movie already exists in your list",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            Toast.makeText(
                this@SearchActivity,
                e.message,
                Toast.LENGTH_SHORT
            )
                .show()
        }

    }


}
