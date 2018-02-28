package com.zxjdev.smile.presentation.moment

import android.os.Parcel
import android.os.Parcelable
import com.zxjdev.smile.presentation.user.UserModel
import java.util.*

class MomentModel() : Parcelable {

    var owner: UserModel? = null
    var content: String? = null
    var createAt: Date? = null

    constructor(parcel: Parcel) : this() {
        owner = parcel.readParcelable(UserModel::class.java.classLoader)
        content = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(this.owner, flags)
        dest.writeString(this.content)
        dest.writeLong(if (this.createAt != null) this.createAt!!.time else -1)
    }

    companion object CREATOR : Parcelable.Creator<MomentModel> {
        override fun createFromParcel(parcel: Parcel): MomentModel {
            return MomentModel(parcel)
        }

        override fun newArray(size: Int): Array<MomentModel?> {
            return arrayOfNulls(size)
        }
    }
}
