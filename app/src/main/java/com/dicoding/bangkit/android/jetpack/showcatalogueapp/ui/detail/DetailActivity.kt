package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.TYPE_MOVIE
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.TYPE_TVSHOW
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.setImageWithGlide
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.ActivityDetailBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var dataModelPojo: DataModelPojo
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]


        //get intent from main activity fragment movie/tvshow depentt on type
        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_movie))
            id?.let {
                detailViewModel.setMovieId(it)
            }
            dataModelPojo = detailViewModel.getDetailMovieById()

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            setupToolbarTitle(resources.getString(R.string.toolbar_title_detail_tvshow))
            id?.let {
                detailViewModel.setTvShowId(it)
            }
            dataModelPojo = detailViewModel.getDetailTvShowById()
        }

        binding.tvDetailName.text = dataModelPojo.name
        binding.tvDetailDesc.text = dataModelPojo.desc
        setImageWithGlide(this@DetailActivity, dataModelPojo.poster, binding.imgDetailPoster)
        setImageWithGlide(
            this@DetailActivity,
            dataModelPojo.img_preview,
            binding.imgDetailHightlight
        )

    }


    private fun setupToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}