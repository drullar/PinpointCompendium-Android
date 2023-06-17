package com.example.pinpointcompendium_android.activities

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

abstract class BaseActivity : FragmentChangeListener, AppCompatActivity() {

    override fun addFragment(fragmentContainerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .add(fragmentContainerId, fragment)
            .commit()
    }

    override fun replaceFragment(fragmentId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .replace(fragmentId, fragment)
            .commit()
    }

    lateinit var fragmentContainerView: FragmentContainerView

    fun setFragmentContainerView(@IdRes containerViewId: Int) {
        fragmentContainerView = findViewById(containerViewId)
    }

}