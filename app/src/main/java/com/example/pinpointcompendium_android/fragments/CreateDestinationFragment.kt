package com.example.pinpointcompendium_android.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.activities.NewAlbumActivity

class CreateDestinationFragment : BaseFragment() {

    private var addAlbumButton: Button? = null

    private val newAlbumIntentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // TODO Get Album data
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
                newAlbumIntentLauncher.launch(Intent(activity, NewAlbumActivity::class.java))
            }
        }
    }
}