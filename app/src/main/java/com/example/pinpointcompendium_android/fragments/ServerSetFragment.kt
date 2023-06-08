package com.example.pinpointcompendium_android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pinpointcompendium_android.FragmentChanger
import com.example.pinpointcompendium_android.R

class ServerSetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.server_set_fragment, container, false)
        var skipButton = view.findViewById<Button>(R.id.server_skip_button).apply {
            this.setOnClickListener(View.OnClickListener {
                fun onClick(v: View) {
                    goToLandingPage()
                }
            })
        }

        return view
    }

    private fun goToLandingPage() {
        var fragmentChangeListener = activity as FragmentChanger
        fragmentChangeListener.replaceFragment(R.id.main_fragment_container, LandingPageFragment())
    }
}