package com.example.pinpointcompendium_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.pinpointcompendium_android.fragments.ServerSetFragment
import com.example.pinpointcompendium_android.fragments.SettingsFragment

class MainActivity : AppCompatActivity(), FragmentChanger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(R.id.main_fragment_container, ServerSetFragment())
    }

    override fun replaceFragment(@IdRes fragmentId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(fragmentId, fragment)
            .commit()
    }

}


