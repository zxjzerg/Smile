package com.zxjdev.smile.data.moment.datasource

import com.zxjdev.smile.data.moment.entity.MomentEntity
import io.reactivex.Observable
import javax.inject.Inject

class MomentCloudDataSource @Inject constructor(private val momentService: MomentCloudService) {

    val momentList: Observable<List<MomentEntity>>
        get() = momentService.momentList

    fun addMoment(content: String): Observable<Void> {
        return momentService.addMoment(content)
    }
}
