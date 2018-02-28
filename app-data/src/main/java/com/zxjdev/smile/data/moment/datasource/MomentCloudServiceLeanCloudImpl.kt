package com.zxjdev.smile.data.moment.datasource

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVObject
import com.avos.avoscloud.AVQuery
import com.zxjdev.smile.data.BuildConfig
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.user.entity.UserEntity

import javax.inject.Inject

import io.reactivex.Observable

class MomentCloudServiceLeanCloudImpl @Inject
constructor(private val currentUser: UserEntity) : MomentCloudService {

    override val momentList: Observable<List<MomentEntity>>
        get() = Observable.create { emitter ->
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
