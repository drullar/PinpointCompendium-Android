package com.example.pinpointcompendium_android.models

import kotlinx.android.parcel.Parcelize

@Parcelize
class Album(override var name: String?, var images: List<Image>?) : DataModel()