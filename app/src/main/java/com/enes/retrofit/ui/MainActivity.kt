package com.enes.retrofit.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.enes.retrofit.R
import com.enes.retrofit.adapter.DogRecyclerViewAdapter
import com.enes.retrofit.viewModel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val dogViewModel: DogViewModel by viewModels()
    private lateinit var dogAdapter: DogRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        dogAdapter = DogRecyclerViewAdapter(listOf())
        val dogLayoutManager = GridLayoutManager(
            this,
            2,
            GridLayoutManager.VERTICAL,
            false
        )

        dogRecyclerViewContainer.apply {
            adapter = dogAdapter
            layoutManager = dogLayoutManager
        }
    }

    private fun setupObserver() {
        //View Model içerisinde yapılan request sonucu değiştiği an burası tetikleniyor ve içeriisndeki işlemler gerçekleşiyor.
        dogViewModel.dogData.observe(this, Observer { dogList ->
            dogAdapter.photoList = dogList.message
            dogAdapter.notifyDataSetChanged()
        })
    }

    override fun onStart() {
        super.onStart()
        setupObserver()
    }
}