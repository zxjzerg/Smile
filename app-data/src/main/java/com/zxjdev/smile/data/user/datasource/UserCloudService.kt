package com.zxjdev.smile.data.user.datasource

import io.reactivex.Observable

interface UserCloudService {

    fun uploadAvatar(localPath: String): Observable<String>
}
