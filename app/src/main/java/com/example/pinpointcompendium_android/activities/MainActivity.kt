package com.example.pinpointcompendium_android.activities

import android.os.Bundle
import android.view.View
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.fragments.LandingPageFragment
import com.example.pinpointcompendium_android.fragments.NewDestinationFragment
import com.example.pinpointcompendium_android.fragments.ServerSetFragment

class MainActivity : BaseActivity() {

    private var isServerSet: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentContainerView(R.id.main_fragment_container)
        addFragment(fragmentContainerView.id, NewDestinationFragment())
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

}


