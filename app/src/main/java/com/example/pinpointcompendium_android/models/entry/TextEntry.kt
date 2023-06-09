package com.example.pinpointcompendium_android.models.entry

import com.example.pinpointcompendium_android.R
import java.util.*

class TextEntry : Entry() {
    override lateinit var name: String
    override var description: String? = null
    override var startDate: Date? = null
    override var endDate: Date? = null
    override var entryDrawableId: Int = R.drawable.baseline_text_snippet_24
    override val entrySpecificItemsLayout: Int = R.id.text_entry_specific_items
    override val entryTypeDescriptor: String = "Text Entry"
}