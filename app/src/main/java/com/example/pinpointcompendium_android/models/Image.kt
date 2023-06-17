package com.example.pinpointcompendium_android.models

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

class Image(var uri: Uri?) : Parcelable {

    override fun describeContents(): Int = 0

    override fun writeToParcel(destination: Parcel, flags: Int) {
        destination.writeString(uri.toString())
    }

    protected constructor(input: Parcel) : this(Uri.parse(input.readString()))

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image {
            return Image(parcel)
        }

        override fun newArray(size: Int): Array<Image?> {
            return arrayOfNulls(size)
        }
    }
}