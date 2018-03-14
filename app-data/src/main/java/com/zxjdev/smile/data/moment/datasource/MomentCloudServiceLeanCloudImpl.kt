package com.zxjdev.smile.data.moment.datasource

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVObject
import com.zxjdev.smile.data.BuildConfig
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.user.entity.UserEntity
import io.reactivex.Observable
import javax.inject.Inject

class MomentCloudServiceLeanCloudImpl @Inject constructor(private val currentUser: UserEntity) : MomentCloudService {

    override fun getMomentList(): Observable<List<MomentEntity>> {
        return Observable.create { emitter ->
            val query = AVObject.getQuery(MomentEntity::class.java)
            query.whereEqualTo("user", currentUser)
            query.include("user")
            query.limit(BuildConfig.QUERY_LIMIT)
            query.orderByDescending("createdAt")
            try {
                emitter.onNext(query.find())
                emitter.onComplete()
            } catch (e: AVException) {
                emitter.tryOnError(e)
            }
        }
    }

    override fun addMoment(content: String): Observable<Void> {
        return Observable.create { emitter ->
            val momentEntity = MomentEntity()
            momentEntity.content = content
            momentEntity.setOwner(currentUser)
            try {
                momentEntity.save()
                emitter.onComplete()
            } catch (e: AVException) {
                emitter.tryOnError(e)
            }
        }
    }
}
