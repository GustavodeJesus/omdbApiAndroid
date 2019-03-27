package com.gustavo.findmovies.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.crosoften.findmovies.R
import com.gustavo.findmovies.view.viewmodel.MovieDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        if (intent.extras != null) {
            val imdbId = intent.extras.getString("ID_MOVIE", "")
            val viewModel = ViewModelProviders.of(this)[MovieDetailViewModel::class.java]

            viewModel
                    .getDetailMovie(imdbId)
                    .observe(this, Observer {
                        if (it != null) {
                            Picasso.get().load(it.poster).into(img_poster_movie)
                            text_title_movie.text = it.title
                            text_description_movie.text = it.plot
                        }
                    })
        }

    }
}
