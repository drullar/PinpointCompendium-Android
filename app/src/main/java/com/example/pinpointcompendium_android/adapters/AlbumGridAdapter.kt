package com.example.pinpointcompendium_android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.activities.FragmentChangeListener
import com.example.pinpointcompendium_android.fragments.PreviewImageFragment
import com.example.pinpointcompendium_android.models.Image

class AlbumGridAdapter(
    context: Context,
    var images: List<Image>,
    val fragmentChangeListener: FragmentChangeListener
) :
    ArrayAdapter<Image>(context, 0, images),
    OnItemClickListener {

    private var lastPosition = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.album_grid_layout, parent, false)
        lastPosition = position
        val imageUri = getItem(position)?.uri
        var imageView = view.findViewById<ImageView>(R.id.album_image)
        imageView.setImageURI(imageUri)
        return view
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (view?.id) {
            R.id.album_image -> {
                fragmentChangeListener.addFragment(
                    R.id.preview_image_container_view,
                    PreviewImageFragment(getItem(position)?.uri)
                )
            }
        }
    }

}