package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home

import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.DataDummy
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo

class MainViewModel : ViewModel() {

    fun getListMovie(): List<DataModelPojo> = DataDummy.generateDataMovieDummy()

    fun getListTvShow(): List<DataModelPojo> = DataDummy.generateDataTvShowDummy()
}