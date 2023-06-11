package com.example.pinpointcompendium_android.models

import android.location.Location
import java.util.*

abstract class DataModel() {
    abstract var name: String
    abstract var startDate: Date?
    abstract var endDate: Date?
    abstract var rate: Int
    abstract var location: Location?
}