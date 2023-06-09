package com.example.pinpointcompendium_android.models.entry

import com.example.pinpointcompendium_android.R
import java.util.*

class ImageEntry : Entry() {
    override lateinit var name: String
    override var description: String? = null
    override var startDate: Date? = null
    override var endDate: Date? = null
    override val entryDrawableId: Int = R.drawable.baseline_image_24
    override val entrySpecificItemsLayout: Int = R.id.image_entry_specific_items
    override val entryTypeDescriptor: String = "Image Entry"
}