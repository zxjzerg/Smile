package com.zxjdev.smile.data.authorization

import com.zxjdev.smile.data.authorization.datasource.AuthorizationCloudDataSource
import com.zxjdev.smile.data.base.BaseDataRepository
import com.zxjdev.smile.domain.authorization.AuthorizationRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import javax.inject.Inject

class AuthorizationDataRepository @Inject constructor(
        private val authorizationCloudDataSource: AuthorizationCloudDataSource) : BaseDataRepository(), AuthorizationRepository {

    override fun register(username: String, password: String): Completable {
        return Completable.create({ e ->
            authorizationCloudDataSource.register(username, password)
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategyForCompletable())
    }

    override fun login(username: String, password: String): Completable {
        return Completable.create({ e ->
            authorizationCloudDataSource.login(username, password)
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategyForCompletable())
    }

    override fun checkIsLogined(): Observable<Boolean> {
        return Observable.create({ e: ObservableEmitter<Boolean> ->
            e.onNext(authorizationCloudDataSource.checkIsLogined())
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategy())
    }

    override fun logout(): Completable {
        return Completable.create({ e ->
            authorizationCloudDataSource.logout()
            e.onComplete()
        }).compose(applyDefaultSchedulerStrategyForCompletable())
    }
}
