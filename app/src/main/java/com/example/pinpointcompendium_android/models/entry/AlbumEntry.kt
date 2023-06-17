package com.example.pinpointcompendium_android.models.entry

import android.content.res.Resources
import android.location.Location
import android.net.Uri
import com.example.pinpointcompendium_android.R
import java.util.*

class AlbumEntry() : Entry() {
    lateinit var name: String
    var location: Location? = null
    var startDate: Date? = null
    var endDate: Date? = null

    //     val entryDrawableId: Int = R.drawable.baseline_image_24
//     val entrySpecificItemsLayout: Int = R.id.album_entry_specific_items
//     val nameHint: String = "Album name"
    var rate: Int = 0
    var imageUri: Uri? = null
}