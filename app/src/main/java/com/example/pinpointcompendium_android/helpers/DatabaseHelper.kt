package com.example.pinpointcompendium_android.helpers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pinpointcompendium_android.models.Destination
import com.example.pinpointcompendium_android.models.database.DatabaseEntryAttributeType

class DatabaseHelper(
    context: Context?,
    private val DATABASE_NAME: String = "pp_database.db",
    private val DATBASE_VERSION: Int = 1
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATBASE_VERSION) {


    // DESTINATIONS
    val DESTINATIONS_TABLE = "destinations"
    val DESTINATION_ID = "_ID"
    val DESTINATION_NAME = "destination_name"

    // ALBUMS
    val ALBUMS_TABLE = "albums"
    val ALBUM_ID = "_ID"
    val ALBUM_NAME = "album_name"

    // IMAGES
    val IMAGES_TABLE = "albums"
    val IMAGE_URI = "URI"

    override fun onCreate(database: SQLiteDatabase?) {

        // CREATE DESTINATIONS DATABASE
        var SQL_CREATE_DESTINATIONS_TABLE = "CREATE TABLE $DESTINATIONS_TABLE (" +
                "$DESTINATION_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$DESTINATION_NAME TEXT NOT NULL);"
        database?.execSQL(SQL_CREATE_DESTINATIONS_TABLE)

        // CREATE ALBUMS DATABASE

        var SQL_CREATE_ALBUMS_TABLE = "CREATE TABLE $ALBUMS_TABLE (" +
                "$ALBUM_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$ALBUM_NAME TEXT NOT NULL);" //TODO ADD DESTINATION_ID FOREIGN KEY
        database?.execSQL(SQL_CREATE_ALBUMS_TABLE)

        // CREATE ALBUMS DATABASE

        var SQL_CREATE_IMAGES_TABLE = "CREATE TABLE $IMAGES_TABLE (" +
                "$IMAGE_URI TEXT PRIMARY KEY);" //TODO ADD ALBUM_ID FOREIGN KEY
        database?.execSQL(SQL_CREATE_IMAGES_TABLE)

    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        database?.execSQL("DROP TABLE IF EXISTS $DESTINATIONS_TABLE")
        onCreate(database)
    }

    fun saveDestination(database: SQLiteDatabase?, destination: Destination) {
        var values = ContentValues()
        values.put(DESTINATION_NAME, destination.name)
        database?.insert(DESTINATIONS_TABLE, null, values)
        values.clear()

    }

    private fun createTable(
        tableName: String,
        primaryKey: String,
        attributes: Map<DatabaseEntryAttributeType, String>
    ) {
        // TODO remove code redundancy by implementing createTable() method
    }
}