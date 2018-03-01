package com.zxjdev.smile.data.authorization.datasource

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVUser
import com.zxjdev.smile.data.user.entity.UserEntity
import io.reactivex.Observable
import javax.inject.Inject

class AuthorizationCloudServiceLeanCloudImpl @Inject constructor() : AuthorizationCloudService {

    override fun register(username: String, password: String): Observable<Void> {
        return Observable.create { emitter ->
            val user = AVUser()
            user.username = username
            user.setPassword(password)
            try {
                user.signUp()
                emitter.onComplete()
            } catch (e: AVException) {
                emitter.tryOnError(e)
            }
        }
    }

    override fun login(username: String, password: String): Observable<Void> {
        return Observable.create { emitter ->
            try {
                AVUser.logIn(username, password, UserEntity::class.java)
                emitter.onComplete()
            } catch (e: AVException) {
                emitter.tryOnError(e)
            }
        }
    }

    override fun checkIsLogined(): Observable<Boolean> {
        return Observable.create { emitter ->
            emitter.onNext(AVUser.getCurrentUser() != null)
            emitter.onComplete()
        }
    }

    override fun logout(): Observable<Void> {
        return Observable.create { emitter ->
            AVUser.logOut()
            emitter.onComplete()
        }
    }
}
