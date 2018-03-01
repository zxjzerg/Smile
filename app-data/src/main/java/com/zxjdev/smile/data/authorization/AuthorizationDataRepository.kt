package com.zxjdev.smile.data.authorization

import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudDataSource
import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.domain.authorization.AuthorizationRepository
import io.reactivex.Observable
import javax.inject.Inject

class AuthorizationDataRepository @Inject constructor(
        private val authorizationCloudDataSource: AuthorizationCloudDataSource) : BaseDataRepository(), AuthorizationRepository {

    override fun register(username: String, password: String): Observable<Void> {
        return authorizationCloudDataSource.register(username, password).compose(applyDefaultSchedulerStrategy())
    }

    override fun login(username: String, password: String): Observable<Void> {
        return authorizationCloudDataSource.login(username, password).compose(applyDefaultSchedulerStrategy())
    }

    override fun checkIsLogined(): Observable<Boolean> {
        return authorizationCloudDataSource.checkIsLogined().compose(applyDefaultSchedulerStrategy())
    }

    override fun logout(): Observable<Void> {
        return authorizationCloudDataSource.logout().compose(applyDefaultSchedulerStrategy())
    }
}
