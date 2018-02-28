package com.zxjdev.smile.data.moment

import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource
import com.zxjdev.smile.data.moment.entity.MomentMapper
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.domain.moment.MomentRepository

import javax.inject.Inject

import io.reactivex.Observable

class MomentDataRepository @Inject
constructor(private val momentCloudDataSource: MomentCloudDataSource, private val momentMapper: MomentMapper) : BaseDataRepository(), MomentRepository {

    override fun addMoment(content: String): Observable<Void> {
        return momentCloudDataSource.addMoment(content).compose(applyDefaultSchedulerStrategy())
    }

    override fun queryMomentList(): Observable<List<Moment>> {
        return momentCloudDataSource.momentList
                .map { momentEntities -> momentMapper.transform(momentEntities) }
                .compose(applyDefaultSchedulerStrategy())
    }

    override fun queryMoment(momentId: String): Observable<Moment>? {
        return null
    }
}
