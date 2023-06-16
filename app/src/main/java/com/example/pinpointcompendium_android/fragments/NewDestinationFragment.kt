package com.example.pinpointcompendium_android.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.adapters.EntryListAdapter
import com.example.pinpointcompendium_android.models.Destination
import com.example.pinpointcompendium_android.models.entry.AlbumEntry
import com.example.pinpointcompendium_android.models.entry.Entry
import com.example.pinpointcompendium_android.models.entry.TextEntry
import com.google.android.material.textfield.TextInputEditText
import java.io.File


class NewDestinationFragment : BaseFragment() {
    lateinit var spinner: Spinner
    private var entries = ArrayList<Entry>()
    private var spinnerAdapter: ArrayAdapter<CharSequence>? = null
    var entryListAdapter: EntryListAdapter? = null
    private var imageUri: Uri? = null
    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
                setImageFromUri(uri)
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

    private var lastAddedEntry: AlbumEntry? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.new_destination_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonsOnClickListener(view)
        configureSpinner(view)
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
                openGalleryForResult()
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
                lastAddedEntry = entryInstance
                view?.findViewById<Button>(R.id.add_from_gallery_button)?.visibility = View.VISIBLE
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
        var getImageFromGallery =
            view.findViewById<Button>(R.id.add_from_gallery_button).apply {
                setOnClickListener(this@NewDestinationFragment)
            }
    }

    private fun configureSpinner(view: View) {
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

    private fun openGalleryForResult() {
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
    }

    private fun setImageFromUri(uri: Uri) {
//        var imageView = view?.findViewById<ImageView>(R.id.temp_image_view)?.apply {
//            Log.v("URI2", uri.toString())
//            setImageURI(null)
//            setImageURI(uri)
//        }.also {
//            Log.v("Log:", "Image uri assigned")
//        }
        entryListAdapter?.updateAlbumEntry(
            lastAddedEntry,
            lastAddedEntry?.apply { this.imageUri = uri },
            view
        )
    }

}