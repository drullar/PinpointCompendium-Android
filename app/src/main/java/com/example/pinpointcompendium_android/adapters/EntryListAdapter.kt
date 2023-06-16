package com.example.pinpointcompendium_android.adapters

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.models.entry.Entry
import com.example.pinpointcompendium_android.models.entry.AlbumEntry


class EntryListAdapter(
    context: Context,
    var entries: ArrayList<Entry>
) : ArrayAdapter<Entry>(context, 0, entries) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var currentItemView = convertView
        if (currentItemView == null)
            currentItemView =
                LayoutInflater.from(context).inflate(R.layout.entry_list_view, parent, false)
        var currentEntryInstance = getItem(position)
        setEntrySpecificProperties(currentEntryInstance, currentItemView)
        return currentItemView!!
    }

    private fun setEntrySpecificProperties(currentEntry: Entry?, view: View?) {
        var entryDrawable = view?.findViewById<ImageView>(R.id.entry_icon)
        var entryViewIcon =
            currentEntry?.entryDrawableId?.let { entryDrawable?.setImageResource(it) }
        var nameHint = view?.findViewById<EditText>(R.id.entry_name)?.apply {
            hint = currentEntry?.nameHint
        }
        when (currentEntry) {
            is AlbumEntry -> {
                view?.findViewById<LinearLayout>(currentEntry.entrySpecificItemsLayout)?.visibility =
                    View.VISIBLE
            }
        }
    }

    fun updateAlbumEntry(entryInList: AlbumEntry?, modifiedEntry: AlbumEntry?, view: View?) {
        if (entryInList != null && modifiedEntry != null) {
            entries.set(entries.indexOf(entryInList), modifiedEntry)
            notifyDataSetChanged()
            Log.v("URI", modifiedEntry.imageUri.toString())
            view?.findViewById<ImageView>(R.id.imageEntityImage)?.apply {
                setImageURI(modifiedEntry.imageUri)
            }

        }
    }

}
