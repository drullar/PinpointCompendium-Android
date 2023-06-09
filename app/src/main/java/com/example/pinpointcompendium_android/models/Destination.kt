package com.example.pinpointcompendium_android.models

import android.location.Location
import com.example.pinpointcompendium_android.models.entry.Entry
import java.util.*

class Destination() : DataModel() {
    override lateinit var name: String
    override var description: String? = null
    override var startDate: Date? = null
    override var endDate: Date? = null
    var location: Location? = null
    var entries: List<Entry>? = null

    private constructor(
        name: String,
        description: String?,
        startDate: Date?,
        endDate: Date?,
        location: Location?,
        entries: List<Entry>?
    ) : this() {
        this.name = name
        this.description = description
        this.startDate = startDate
        this.endDate = endDate
        this.location = location
        this.entries = entries
    }

    class Builder : DataModel() {
        override lateinit var name: String
        override var description: String? = null
        override var startDate: Date? = null
        override var endDate: Date? = null
        var location: Location? = null
        var entries: List<Entry>? = null

        fun Name(name: String): Builder {
            this.name = name
            return this
        }

        fun Description(description: String?): Builder {
            this.description = description
            return this
        }

        fun StartDate(startDate: Date?): Builder {
            this.startDate = startDate
            return this
        }

        fun EndDate(endDate: Date?): Builder {
            this.endDate = endDate
            return this
        }

        fun Location(location: Location?): Builder {
            this.location = location
            return this
        }

        fun Entries(entries: List<Entry>?): Builder {
            this.entries = entries
            return this
        }

        fun build(): Destination =
            Destination(name, description, startDate, endDate, location, entries)

    }
}