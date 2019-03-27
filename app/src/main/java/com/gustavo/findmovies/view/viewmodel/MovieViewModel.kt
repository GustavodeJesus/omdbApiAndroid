package com.gustavo.findmovies.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gustavo.findmovies.data.db.MoviesDatabase
import com.gustavo.findmovies.data.repository.MoviesRepository
import com.gustavo.findmovies.data.entity.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    /**
     *  ViewModel Responável por Manipular dados de persistencia da isntancia do Room Database
     *  Obs.: Utilizando Coroutines do Kotlin para executar as funções assincronas do banco de dados.
     * */
    private val repository: MoviesRepository
    val allMovies: LiveData<List<Movie>>

    private var parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    /**
     *  Inicialização dos componentes do MoviesDataBase
     * */
    init {
        val movieDao = MoviesDatabase.getMovieDatabase(application,scope).movieDao()
        repository = MoviesRepository(movieDao)
        allMovies = repository.allMovies

    }

    fun insert(movie: Movie) = scope.launch(Dispatchers.IO) {
        repository.insert(movie)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}