package com.zxjdev.smile.presentation.user

import android.os.Parcel
import android.os.Parcelable

class UserModel() : Parcelable {

    var username: String? = null
    var avatar: String? = null

    constructor(parcel: Parcel) : this() {
        username = parcel.readString()
        avatar = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}
