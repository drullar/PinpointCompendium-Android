package com.example.pinpointcompendium_android.models

import android.location.Location
import android.os.Parcelable
import java.util.*

abstract class DataModel() : Parcelable {
    abstract var name: String?
}