package com.enes.retrofit.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enes.retrofit.model.Dog
import com.enes.retrofit.service.RetrofitApi
import kotlinx.coroutines.launch

class DogViewModel @ViewModelInject constructor(private var retrofitApi: RetrofitApi) : ViewModel() {

    private var _dogData = MutableLiveData<Dog>()
    val dogData: LiveData<Dog>
        get() = _dogData

    //Bu sınıftan bi nesne üretildiği an init bloğu tetiklenecek
    init {
        getDogData()
    }

    private fun getDogData() {
        //Request işlemi Main Thread'i bloklamaması için viewModelScope içerisine yapıyoruz.
        viewModelScope.launch {
            try {
                _dogData.value = retrofitApi.getDogData()
            } catch (e: Exception) {
                makeLog(e.message)
            }
        }
    }

    private fun makeLog(message: String?) {
        message?.let {
            Log.e("Dog View Model", message)
        }
    }
}