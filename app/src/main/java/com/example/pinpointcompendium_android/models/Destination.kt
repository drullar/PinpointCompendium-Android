package com.example.pinpointcompendium_android.models

import android.location.Location
import android.os.Parcel
import android.os.Parcelable
import com.example.pinpointcompendium_android.models.entry.Entry
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Destination(override var name: String?, var album: Album?) : DataModel()