package com.example.pinpointcompendium_android.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.pinpointcompendium_android.R
import com.example.pinpointcompendium_android.activities.BaseActivity

class LandingPageFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.landing_page_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.v("Fragment: ", "onViewCreated() is called")
        super.onViewCreated(view, savedInstanceState)
        var firstDestinationButton: Button =
            view.findViewById(R.id.add_first_destination_button)
        firstDestinationButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add_first_destination_button -> {
                if (fragmentChangerListenerIsNull())
                    initFragmentChanger()
                fragmentChangeListener?.replaceFragment(
                    R.id.main_fragment_container,
                    NewDestinationFragment()
                )
            }
        }
    }
}