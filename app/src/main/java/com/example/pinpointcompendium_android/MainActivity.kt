package com.example.pinpointcompendium_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pinpointcompendium_android.fragments.ServerSetFragment
import com.example.pinpointcompendium_android.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragment_container, ServerSetFragment())
            .commit()
    }
}


