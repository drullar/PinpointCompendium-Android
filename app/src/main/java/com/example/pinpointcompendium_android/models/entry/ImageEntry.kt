package com.example.pinpointcompendium_android.models.entry

import android.location.Location
import java.util.*

class ImageEntry : Entry() {
    override var name: String = ""
    override var startDate: Date? = null
    override var endDate: Date? = null
    override var rate: Int = 0
    override var location: Location? = null

}