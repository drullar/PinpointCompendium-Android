package com.example.pinpointcompendium_android.models.entry

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.example.pinpointcompendium_android.models.DataModel
import java.util.*

abstract class Entry : DataModel() {
    abstract override var name: String
    abstract override var description: String?
    abstract override var startDate: Date?
    abstract override var endDate: Date?
    abstract val entryDrawableId: Int
    abstract val entrySpecificItemsLayout: Int
    open val entryTypeDescriptor: String = "Entry"
}