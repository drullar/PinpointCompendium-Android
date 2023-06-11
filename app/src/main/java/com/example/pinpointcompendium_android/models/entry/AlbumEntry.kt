package com.example.pinpointcompendium_android.models.entry

import android.content.res.Resources
import android.location.Location
import com.example.pinpointcompendium_android.R
import java.util.*

class AlbumEntry() : Entry() {
    override lateinit var name: String
    override var location: Location? = null
    override var startDate: Date? = null
    override var endDate: Date? = null
    override val entryDrawableId: Int = R.drawable.baseline_image_24
    override val entrySpecificItemsLayout: Int = R.id.album_entry_specific_items
    override val nameHint: String = "Album name"
    override var rate: Int = 0
}