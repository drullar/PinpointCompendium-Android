package com.example.pinpointcompendium_android.activities

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

interface FragmentChangeListener {
    fun addFragment(@IdRes fragmentId: Int, fragment: Fragment)
    fun replaceFragment(@IdRes fragmentId: Int, fragment: Fragment)
}