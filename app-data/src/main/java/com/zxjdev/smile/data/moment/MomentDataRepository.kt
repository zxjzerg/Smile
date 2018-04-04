package com.zxjdev.smile.data.moment

import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.moment.entity.MomentMapper
import com.zxjdev.smile.domain.moment.Moment
import com.zxjdev.smile.domain.moment.MomentRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import javax.inject.Inject

class MomentDataRepository @Inject constructor(private val momentCloudDataSource: MomentCloudDataSource,
        private val momentMapper: MomentMapper) : BaseDataRepository(), MomentRepository {

    override fun addMoment(content: String): Completable {
        return Completable.create({ e ->
            momentCloudDataSource.addMoment(content)
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategyForCompletable())
    }

    override fun queryMomentList(): Observable<List<Moment>> {
        return Observable.create({ e: ObservableEmitter<List<MomentEntity>> ->
            e.onNext(momentCloudDataSource.getMomentList())
            e.onComplete()
        }).map { momentEntities -> momentMapper.transform(momentEntities) }.compose(applyDefaultSchedulerStrategy())
    }

    override fun queryMoment(momentId: String): Observable<Moment>? {
        return null
    }
}
