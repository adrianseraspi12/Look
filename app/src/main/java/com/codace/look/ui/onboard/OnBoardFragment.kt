package com.codace.look.ui.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.codace.look.R

import kotlinx.android.synthetic.main.fragment_onboard.*

class OnBoardFragment: Fragment() {

    companion object {

        const val ONBOARD_IMAGE = "ONBOARD_IMAGE"
        const val ONBOARD_TITLE = "ONBOARD_TITLE"
        const val ONBOARD_DESCRIPTION = "ONBOARD_DESCRIPTION"


        fun newInstance(@DrawableRes image: Int, @StringRes title: Int, @StringRes description: Int): Fragment {
            val fragment = OnBoardFragment()
            val bundle = Bundle()

            bundle.putInt(ONBOARD_IMAGE, image)
            bundle.putInt(ONBOARD_TITLE, title)
            bundle.putInt(ONBOARD_DESCRIPTION, description)
            fragment.arguments = bundle

            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_onboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments

        if (bundle != null) {
            onboard_image.setImageResource(bundle.getInt(ONBOARD_IMAGE))
            onboard_title.setText(bundle.getInt(ONBOARD_TITLE))
            onboard_description.setText(bundle.getInt(ONBOARD_DESCRIPTION))
        }

    }

}