package com.example.pinpointcompendium_android.activities

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
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
import com.example.pinpointcompendium_android.helpers.DatabaseHelper
import com.example.pinpointcompendium_android.models.Album
import com.example.pinpointcompendium_android.models.Image
import com.google.android.material.textfield.TextInputEditText

class NewAlbumActivity : BaseActivity(), OnClickListener {

    // Grid View and Adapter
    private lateinit var albumGridAdapter: AlbumGridAdapter
    private var gridView: GridView? = null
    private var images = ArrayList<Image>()

    // XML Layout elements
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_layout)
        albumGridAdapter = AlbumGridAdapter(this, images, this)
        gridView = findViewById<GridView?>(R.id.album_grid_view).apply {
            adapter = albumGridAdapter
        }
        Log.v("Activity", "NewAlbumActivity in onCreate method")

        // Set Listeners

        findViewById<Button>(R.id.add_images_button).setOnClickListener(this)
        findViewById<Button>(R.id.save_album_button).setOnClickListener(this)
    }

    private fun appendImagesFromUri(uriList: List<Uri>) {
        for (uri: Uri in uriList) {
            images.add(Image(uri))
            albumGridAdapter.notifyDataSetChanged()
        }
//        albumGridAdapter.add(Image(uri))

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.add_images_button -> {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
            }
            R.id.save_album_button -> {
                saveAlbum(view)
            }
        }
    }

    private fun saveAlbum(v: View?) {
        var data = Intent()
        var album = Album(
            v?.findViewById<TextInputEditText>(R.id.album_name_input)?.text.toString(),
            images
        )
        data.putExtra("album", album)
        setResult(RESULT_OK, data);
        finish()
    }
}