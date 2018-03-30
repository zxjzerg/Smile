package com.zxjdev.smile.data.moment.datasource

import com.zxjdev.smile.data.moment.entity.MomentEntity
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class MomentCloudDataSource @Inject constructor(private val momentService: MomentCloudService) {

    fun getMomentList(): Observable<List<MomentEntity>> {
        return momentService.getMomentList()
    }

    fun addMoment(content: String): Completable {
        return momentService.addMoment(content)
    }
}
