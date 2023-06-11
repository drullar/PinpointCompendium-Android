package com.example.pinpointcompendium_android.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.models.entry.Entry
import com.example.pinpointcompendium_android.models.entry.AlbumEntry
import com.example.pinpointcompendium_android.models.entry.TextEntry
import org.w3c.dom.Text


class EntryListAdapter(context: Context, var entries: List<Entry>) :
    ArrayAdapter<Entry>(context, 0, entries) {

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
}
