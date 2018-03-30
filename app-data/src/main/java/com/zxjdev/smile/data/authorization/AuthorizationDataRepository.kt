package com.zxjdev.smile.data.authorization

import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudDataSource
import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.domain.authorization.AuthorizationRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class AuthorizationDataRepository @Inject constructor(
        private val authorizationCloudDataSource: AuthorizationCloudDataSource) : BaseDataRepository(), AuthorizationRepository {

    override fun register(username: String, password: String): Completable {
        return authorizationCloudDataSource.register(username, password).compose(applyDefaultSchedulerStrategyForCompletable())
    }

    override fun login(username: String, password: String): Completable {
        return authorizationCloudDataSource.login(username, password)
                .compose(applyDefaultSchedulerStrategyForCompletable())
    }

    override fun checkIsLogined(): Observable<Boolean> {
        return authorizationCloudDataSource.checkIsLogined().compose(applyDefaultSchedulerStrategy())
    }

    override fun logout(): Completable? {
        return authorizationCloudDataSource.logout().compose(applyDefaultSchedulerStrategyForCompletable())
    }
}
