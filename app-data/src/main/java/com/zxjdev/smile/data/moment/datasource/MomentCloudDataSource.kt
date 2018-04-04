package com.zxjdev.smile.data.moment.datasource

import com.zxjdev.smile.data.moment.entity.MomentEntity
import javax.inject.Inject

class MomentCloudDataSource @Inject constructor(private val momentService: MomentCloudService) {

    fun getMomentList(): List<MomentEntity> {
        return momentService.getMomentList()
    }

    fun addMoment(content: String) {
        momentService.addMoment(content)
    }
}
