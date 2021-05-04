package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.ui.home.content.DataCallback
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.ui.home.content.DataManagementAdapter
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.FragmentMovieBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail.DetailActivity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.MainViewModel


class MovieFragment : Fragment(), DataCallback {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            mainViewModel = ViewModelProvider(
                it!!,
                ViewModelProvider.NewInstanceFactory()
            )[MainViewModel::class.java]
        }
        val listmovie = mainViewModel.getListMovie()
        setupRecyclerView(listmovie)
    }

    fun setupRecyclerView(data: List<DataModelPojo>) {
        binding.rvMovie.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = DataManagementAdapter(this@MovieFragment)
        }.also {
            it.adapter.let { adapter ->
                when (adapter) {
                    is DataManagementAdapter -> adapter.setData(data)
                }
            }
        }

    }

    override fun onItemClicked(dataPojo: DataModelPojo) {
//        val intent = Intent(context, DetailActivity::class.java)
//        intent.putExtra(DetailActivity.EXTRA_DATA,dataPojo.id)
//        intent.putExtra(DetailActivity.EXTRA_TYPE,Helper.TYPE_TVSHOW)
//        startActivity(intent)
        startActivity(
            Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_DATA, dataPojo.id)
                .putExtra(DetailActivity.EXTRA_TYPE, Helper.TYPE_MOVIE)
        )
    }
}