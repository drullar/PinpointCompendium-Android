package com.example.pinpointcompendium_android.models

import android.location.Location
import com.example.pinpointcompendium_android.models.entry.Entry
import java.util.*

class Destination : DataModel() {
    override lateinit var name: String
    override var startDate: Date? = null
    override var endDate: Date? = null
    override var rate: Int = 0
    override var location: Location? = null
    var entries: List<Entry>? = null
}