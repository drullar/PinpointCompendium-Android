package com.example.pinpointcompendium_android

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

interface FragmentChanger {
    fun replaceFragment(@IdRes fragmentId: Int, fragment: Fragment)
}