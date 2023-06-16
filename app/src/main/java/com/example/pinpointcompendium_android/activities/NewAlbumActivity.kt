package com.example.pinpointcompendium_android.activities

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.GridView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.adapters.AlbumGridAdapter
import com.example.pinpointcompendium_android.models.Image

class NewAlbumActivity : BaseActivity(), OnClickListener {

    private val albumGridAdapter: AlbumGridAdapter? = null
    private var gridView: GridView? = null
    private var addImagesButton: Button? = null

    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia()) { uriList ->
            if (uriList != null) {
                for (uri: Uri in uriList)
                    Log.d("PhotoPicker", "Selected URI: $uri")
                appendImagesFromUri(uriList)
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_layout) // TODO Fix nothing shown on Activity Inflate
        gridView?.findViewById<GridView>(R.id.album_grid_view)
        addImagesButton?.findViewById<Button>(R.id.add_images_button)?.apply {
            setOnClickListener(this@NewAlbumActivity)
        }
    }

    private fun appendImagesFromUri(uriList: List<Uri>) {
        for (uri: Uri in uriList)
            albumGridAdapter?.add(Image(uri))
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.add_images_button -> {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
            }
        }
    }
}