package com.gustavo.findmovies.view.interfaces

import com.gustavo.findmovies.api.reponse.Movies

interface SearchMovie {

    /*
    *   Interface Responável por Manipular a View para apresentar valores encontrados ou não da listagem de filmes.
    * */
    interface View {

        fun showPlate()

        fun hidePlate()

        fun showRes(movieList: List<Movies>)
    }

    /**
     *  Interface Responsável por Manipular a requisição de busca Mediante parametro passado.
     */
    interface Presenter {

        fun onNoSearchParam()

        fun onSearchParam(string: String)
    }

    /*
    *  Interface Responável por Controlar a ação de resposta da request realizada na consumação do endpoint da API
    * */
    interface Model {

        fun getSearchResults(listener: OnMoviesSearchListener, query: String)

        interface OnMoviesSearchListener {

            fun onFinished(movieList: List<Movies>)

            fun onFailure(throwable: Throwable)
        }
    }
}
