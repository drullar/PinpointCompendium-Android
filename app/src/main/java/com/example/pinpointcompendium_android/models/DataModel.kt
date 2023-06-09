package com.example.pinpointcompendium_android.models

import java.util.*

abstract class DataModel() {
    abstract var name: String
    abstract var description: String?
    abstract var startDate: Date?
    abstract var endDate: Date?
}