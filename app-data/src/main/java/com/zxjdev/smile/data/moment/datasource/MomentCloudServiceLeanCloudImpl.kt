package com.zxjdev.smile.data.moment.datasource

import com.avos.avoscloud.AVObject
import com.zxjdev.smile.data.BuildConfig
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.user.entity.UserEntity
import javax.inject.Inject

class MomentCloudServiceLeanCloudImpl @Inject constructor(private val currentUser: UserEntity) : MomentCloudService {

    override fun getMomentList(): List<MomentEntity> {
        val query = AVObject.getQuery(MomentEntity::class.java)
        query.whereEqualTo("user", currentUser)
        query.include("user")
        query.limit(BuildConfig.QUERY_LIMIT)
        query.orderByDescending("createdAt")
        return query.find()
    }

    override fun addMoment(content: String) {
        val momentEntity = MomentEntity()
        momentEntity.content = content
        momentEntity.setOwner(currentUser)
        momentEntity.save()
    }
}
