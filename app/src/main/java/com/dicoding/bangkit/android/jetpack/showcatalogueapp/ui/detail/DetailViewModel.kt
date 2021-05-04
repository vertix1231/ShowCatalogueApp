package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.DataDummy
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo

class DetailViewModel : ViewModel(){
    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataModelPojo> = DataDummy.generateDataMovieDummy() as ArrayList<DataModelPojo>
    private fun getListTvShow(): ArrayList<DataModelPojo> = DataDummy.generateDataTvShowDummy() as ArrayList<DataModelPojo>

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataModelPojo {
        lateinit var result: DataModelPojo
        val listMovie = getListMovie()
        for (movie in listMovie){
            if (movie.id == movieId){
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(): DataModelPojo {
        lateinit var result: DataModelPojo
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow){
            if (tvShow.id == tvShowId){
                result = tvShow
                break
            }
        }
        return result
    }
}