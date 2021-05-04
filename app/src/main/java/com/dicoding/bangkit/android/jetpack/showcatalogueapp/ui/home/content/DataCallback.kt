package com.dicoding.bangkit.android.jetpack.moviecatalogueapp.ui.home.content

import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo

interface DataCallback {
    fun onItemClicked(dataPojo: DataModelPojo)
}