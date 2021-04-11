package com.zxjdev.smile.presentation.moment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zxjdev.smile.presentation.moment.MomentModel

class MomentListViewModel : ViewModel() {

    private val moments: MutableLiveData<List<MomentModel>> by lazy {
        MutableLiveData<List<MomentModel>>()
    }

    fun setMoments(data: List<MomentModel>) {
        moments.value = data
    }

    fun getMoments(): LiveData<List<MomentModel>> {
        return moments
    }
}