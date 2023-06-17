package com.example.pinpointcompendium_android.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.activities.NewAlbumActivity
import com.example.pinpointcompendium_android.helpers.DatabaseHelper
import com.example.pinpointcompendium_android.models.Album
import com.example.pinpointcompendium_android.models.Destination
import com.google.android.material.textfield.TextInputEditText

class CreateDestinationFragment(var dbHelper: DatabaseHelper, var database: SQLiteDatabase) :
    BaseFragment() {


    private var addAlbumButton: Button? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private val newAlbumIntentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                var album = result.data?.getParcelableExtra("album", Album::class.java)
                dbHelper.saveDestination(
                    database,
                    Destination(
                        view?.findViewById<TextInputEditText>(R.id.destination_name_input)?.text.toString(),
                        album
                    )
                )
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.create_destination_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addAlbumButton = view?.findViewById<Button>(R.id.add_album_button)
        addAlbumButton?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.add_album_button -> {
                Log.v("Button Click", "Add Album button clicked")
                var albumActivityIntent = Intent(activity, NewAlbumActivity::class.java)
                startActivity(albumActivityIntent)
            }
        }
    }
}