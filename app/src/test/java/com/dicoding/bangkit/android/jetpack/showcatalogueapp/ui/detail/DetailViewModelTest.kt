package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.detail

import junit.framework.TestCase
import org.junit.Before

class DetailViewModelTest : TestCase() {

    private lateinit var detailViewModel: DetailViewModel

    @Before
    override fun setUp(){
        detailViewModel = DetailViewModel()
    }


    //cek data movie ada 10 item
    fun testGetDetailMovieById() {
        val getDataMovie = detailViewModel.getListMovie()
        assertNotNull(getDataMovie)
        assertEquals(10,getDataMovie.size)
    }

    //cek data tvshow ada 10 item
    fun testGetDetailTvShowById() {
        val getDatatvshow = detailViewModel.getListTvShow()
        assertNotNull(getDatatvshow)
        assertEquals(10,getDatatvshow.size)}
}