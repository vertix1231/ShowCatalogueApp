package com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val TYPE_MOVIE = "TYPE_MOVIE"
    const val TYPE_TVSHOW = "TYPE_TVSHOW"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).load(imagePath).into(imageView)
    }
}