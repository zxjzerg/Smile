package com.zxjdev.smile.data.moment.datasource

import com.zxjdev.smile.data.moment.entity.MomentEntity
import io.reactivex.Observable

interface MomentCloudService {

    /**
     * Get a list of moment
     *
     * @return A list of moment
     */
    fun getMomentList(): Observable<List<MomentEntity>>

    /**
     * Publish a moment
     *
     * @param content text content of moment
     */
    fun addMoment(content: String): Observable<Void>
}
