package com.enes.retrofit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.enes.retrofit.R
import com.enes.retrofit.adapter.DogRecyclerViewAdapter
import com.enes.retrofit.viewModel.DogViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var dogViewModel: DogViewModel
    private lateinit var dogAdapter: DogRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
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

    private fun setupViewModel() {
        dogViewModel = ViewModelProvider(this).get(DogViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        setupObserver()
    }
}