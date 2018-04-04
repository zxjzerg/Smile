package com.zxjdev.smile.data.moment.datasource

import com.zxjdev.smile.data.moment.entity.MomentEntity

interface MomentCloudService {

    /**
     * Get a list of moment
     *
     * @return A list of moment
     */
    fun getMomentList(): List<MomentEntity>

    /**
     * Publish a moment
     *
     * @param content text content of moment
     */
    fun addMoment(content: String)
}
