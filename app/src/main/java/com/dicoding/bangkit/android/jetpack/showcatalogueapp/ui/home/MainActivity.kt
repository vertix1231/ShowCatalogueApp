package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.ActivityMainBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.content.movie.MovieFragment
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.content.tvshow.TvShowFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this@MainActivity,ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]

        setupNavBar()
    }


    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun setupNavBar() {
        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()

        setActiveFragment(movieFragment, resources.getString(R.string.tab_title_movie))

        binding.bottomNavbar.setNavigationChangeListener { view, _ ->
            when (view.id) {
                R.id.nav_movie -> setActiveFragment(movieFragment, resources.getString(R.string.tab_title_movie))

                R.id.nav_tvshow -> setActiveFragment(tvShowFragment, resources.getString(R.string.tab_title_tvshow))
            }
        }
    }

    private fun setActiveFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.container_main_fragment, fragment)
        }.commit()

        setActionBarTitle(title)
    }
}