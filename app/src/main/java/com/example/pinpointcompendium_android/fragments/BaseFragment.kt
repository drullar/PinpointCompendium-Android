package com.example.pinpointcompendium_android.fragments

import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.Fragment
import com.example.pinpointcompendium_android.activities.BaseActivity
import com.example.pinpointcompendium_android.activities.FragmentChangeListener

abstract class BaseFragment : Fragment(), OnClickListener {
    var fragmentChangeListener: BaseActivity? = null

    init {
        initFragmentChanger()
    }

    protected fun fragmentChangerListenerIsNull(): Boolean {
        if (fragmentChangeListener == null)
            return true
        return false
    }

    protected fun initFragmentChanger() {
        if (activity != null)
            fragmentChangeListener = activity as BaseActivity
    }

    protected open fun setButtonsOnClickListener(view: View) {
        /*
            Initialize buttons here and set their onClickListener(this)
         */
    }
}