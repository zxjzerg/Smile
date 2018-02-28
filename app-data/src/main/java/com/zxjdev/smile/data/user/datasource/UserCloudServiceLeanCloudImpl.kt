package com.zxjdev.smile.data.user.datasource

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVFile
import com.zxjdev.smile.data.user.entity.UserEntity

import java.io.FileNotFoundException

import javax.inject.Inject

import io.reactivex.Observable

class UserCloudServiceLeanCloudImpl @Inject
constructor(private val currentUser: UserEntity) : UserCloudService {

    override fun uploadAvatar(localPath: String): Observable<String> {
        return Observable.create { subscriber ->
            try {
                val file = AVFile.withAbsoluteLocalPath("avatar.jpg", localPath)
                file.save()
                currentUser.avatar = file.url
                currentUser.save()
                subscriber.onNext(file.url)
                subscriber.onComplete()
            } catch (e: FileNotFoundException) {
                subscriber.tryOnError(e)
            } catch (e: AVException) {
                subscriber.tryOnError(e)
            }
        }
    }
}
