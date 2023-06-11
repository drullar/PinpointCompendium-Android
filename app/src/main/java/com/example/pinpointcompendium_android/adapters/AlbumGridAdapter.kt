package com.example.pinpointcompendium_android.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.pinpointcompendium_android.models.entry.ImageEntry

class AlbumGridAdapter(context: Context, var entries: ArrayList<ImageEntry>) :
    ArrayAdapter<ImageEntry>(context, 0, entries) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)
    }
}