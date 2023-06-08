package com.example.pinpointcompendium_android.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.pinpointcompendium_android.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}