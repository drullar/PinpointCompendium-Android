package com.example.pinpointcompendium_android.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.adapters.EntryListAdapter
import com.example.pinpointcompendium_android.listeners.ImageListener
import com.example.pinpointcompendium_android.models.Destination
import com.example.pinpointcompendium_android.models.entry.AlbumEntry
import com.example.pinpointcompendium_android.models.entry.Entry
import com.example.pinpointcompendium_android.models.entry.TextEntry
import com.google.android.material.textfield.TextInputEditText


open class NewDestinationFragment : BaseFragment() {
    lateinit var spinner: Spinner
    private var entries = ArrayList<Entry>()
    private var spinnerAdapter: ArrayAdapter<CharSequence>? = null
    private var entryListAdapter: EntryListAdapter? = null
    var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.new_destination_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonsOnClickListener(view)
        setUpSpinners(view)
        entryListAdapter = context?.let { EntryListAdapter(it, entries) }
        var entriesListView = view.findViewById<ListView>(R.id.new_destination_entries_list_view)
            .apply { adapter = entryListAdapter }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.new_destination_add_entry_button -> {
                addEntry(v)
            }
            R.id.submit_destination_button -> {
                submitDestination(v)
            }
            R.id.add_from_gallery_button -> {
                openImageSelectForResult()
            }
            R.id.add_from_camera_button -> {
                var cameraIntent = Intent()
                // TODO Implement Open Camera Intent
            }
        }
    }

    private fun addEntry(v: View) {
        Log.v("ButtonClick", "Add entry button clicked")
        var selectedEntryType =
            view?.findViewById<Spinner>(R.id.new_destination_entries_spinner)?.selectedItem.toString()
        var entryInstance: Entry? = null
        when (selectedEntryType) {
            "Text Entry" -> {
                entryInstance = TextEntry()
            }
            "Album Entry" -> {
                entryInstance = AlbumEntry()
            }
        }
        if (entryInstance != null) {
            entries.add(entryInstance)
            entryListAdapter?.notifyDataSetChanged()
        }
    }

    private fun submitDestination(v: View) {
        Log.v("ButtonClick", "Submit destination button clicked")
        var destinationNameTextView =
            view?.findViewById<TextInputEditText>(R.id.destination_name_input)
        var destinationName = destinationNameTextView?.text
        if (destinationName != null) {
            Destination().apply {
                name = destinationName.toString()
                entries = this@NewDestinationFragment.entries
            }
        } else {
            Toast.makeText(context, "Destination name can not be empty", Toast.LENGTH_SHORT)
            destinationNameTextView?.requestFocus()
        }
    }

    override fun setButtonsOnClickListener(view: View) {
        var addEntryButton =
            view.findViewById<Button>(R.id.new_destination_add_entry_button).apply {
                setOnClickListener(this@NewDestinationFragment)
            }

        var submitDestinationButton =
            view.findViewById<Button>(R.id.submit_destination_button).apply {
                setOnClickListener(this@NewDestinationFragment)
            }

        var mediaFromGalleryButton =
            view.findViewById<Button>(R.id.add_from_gallery_button)?.apply {
                setOnClickListener(this@NewDestinationFragment)
            }

        var mediaFromCameraGalleryButton =
            view.findViewById<Button>(R.id.add_from_camera_button)?.apply {
                setOnClickListener(this@NewDestinationFragment)
            }
    }

    private fun setUpSpinners(view: View) {
        spinnerAdapter = context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.entry_types,
                android.R.layout.simple_spinner_item
            )
        }
        spinnerAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner = view.findViewById<Spinner?>(R.id.new_destination_entries_spinner)
            .apply { adapter = spinnerAdapter }
    }

    var SELECT_PICTURE = 200
    fun openImageSelectForResult() {
        var imageSelectIntent = Intent().apply {
            type = "image/*"
            action = Intent.ACTION_GET_CONTENT
        }
        startActivityForResult(imageSelectIntent, SELECT_PICTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE) {
            var imageUri = data?.data
            view?.findViewById<ImageView>(R.id.test_image)?.setImageURI(imageUri)
        }
    }
}