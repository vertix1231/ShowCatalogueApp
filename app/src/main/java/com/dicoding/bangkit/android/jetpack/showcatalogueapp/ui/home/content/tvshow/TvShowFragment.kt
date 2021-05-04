package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.content.tvshow

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
import com.dicoding.bangkit.android.jetpack.moviecatalogueapp.utils.Helper.TYPE_TVSHOW
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.databinding.FragmentTvShowBinding
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.modelpojo.DataModelPojo
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail.DetailActivity
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.home.MainViewModel


class TvShowFragment : Fragment(), DataCallback {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentTvShowBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            viewModel = ViewModelProvider(it!!, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        }
        val listTvShow = viewModel.getListTvShow()
        setupRecyclerView(listTvShow)
    }

    fun setupRecyclerView(data: List<DataModelPojo>) {
        binding.rvTvshow.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = DataManagementAdapter(this@TvShowFragment)
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
                        .putExtra(DetailActivity.EXTRA_TYPE, TYPE_TVSHOW)
        )
    }

}