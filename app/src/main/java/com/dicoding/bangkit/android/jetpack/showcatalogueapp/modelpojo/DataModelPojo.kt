package com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModelPojo(
    var id: String,
    var name: String,
    var desc: String,
    var poster: String,
    var img_preview: String
) : Parcelable
