package com.zxjdev.smile.presentation.moment.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
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