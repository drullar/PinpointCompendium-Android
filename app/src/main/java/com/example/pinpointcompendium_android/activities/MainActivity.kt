package com.example.pinpointcompendium_android.activities

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.fragments.CreateDestinationFragment
import com.example.pinpointcompendium_android.fragments.LandingPageFragment
import com.example.pinpointcompendium_android.fragments.NewDestinationFragment
import com.example.pinpointcompendium_android.fragments.ServerSetFragment
import com.example.pinpointcompendium_android.helpers.DatabaseHelper

class MainActivity : BaseActivity() {

    // Database variables
    private lateinit var database: SQLiteDatabase
    private lateinit var dbHelper: DatabaseHelper

    // Flags
    private var isServerSet: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentContainerView(R.id.main_fragment_container)

        // Database variable init

        dbHelper = DatabaseHelper(this)
        database = dbHelper.writableDatabase

        // Fragment Management
        addFragment(fragmentContainerView.id, CreateDestinationFragment(dbHelper, database))
//        if (isServerSet)
//            addFragment(fragmentContainerView.id, LandingPageFragment())
//        else {
//            addFragment(fragmentContainerView.id, ServerSetFragment())
//            isServerSet = true
//        }

    }

    fun goToLandingPage(v: View) {
        addFragment(fragmentContainerView.id, LandingPageFragment())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isServerSet", isServerSet)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isServerSet = savedInstanceState.getBoolean("isServerSet")
    }

    override fun onDestroy() {
        database.close()
        dbHelper.close()
        super.onDestroy()
    }

}


