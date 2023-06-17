package com.example.pinpointcompendium_android.models.entry

import android.location.Location
import com.example.pinpointcompendium_android.R
import java.util.*

class TextEntry : Entry() {
    lateinit var name: String

    //    override var location: Location? = null
//    override var startDate: Date? = null
//    override var endDate: Date? = null
    override var entryDrawableId: Int = R.drawable.baseline_text_snippet_24
    override val entrySpecificItemsLayout: Int = R.id.text_entry_specific_items
    override val nameHint: String = "Text Title"
//    override var rate: Int = 0
}