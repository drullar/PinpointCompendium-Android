package com.example.pinpointcompendium_android.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.models.Image
import com.example.pinpointcompendium_android.models.entry.ImageEntry

class AlbumGridAdapter(context: Context, var images: ArrayList<Image>) :
    ArrayAdapter<Image>(context, 0, images) {

    private var lastPosition = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = LayoutInflater.from(context).inflate(R.layout.album_grid_layout, parent, false)
        lastPosition = position
        var imageUri = getItem(position)?.uri
        Log.v("Image", "Adding image with uri: $imageUri")
        view.findViewById<ImageView>(R.id.album_image).setImageURI(imageUri)
        return view
    }
}