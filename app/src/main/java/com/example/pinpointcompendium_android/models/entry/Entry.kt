package com.example.pinpointcompendium_android.models.entry

import com.example.pinpointcompendium_android.models.DataModel

abstract class Entry : DataModel() {
    open val entryDrawableId: Int = 0
    open val entrySpecificItemsLayout: Int = 0
    open val nameHint: String = "Entry"
}