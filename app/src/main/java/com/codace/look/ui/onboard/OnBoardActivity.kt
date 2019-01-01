package com.codace.look.ui.onboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codace.look.R
import kotlinx.android.synthetic.main.activity_onboard.*

class OnBoardActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        //  setUp the ViewPager
        val adapter = OnBoardPagerAdapter(supportFragmentManager)
        onboard_viewpager.adapter = adapter
        onboard_dots.setupWithViewPager(onboard_viewpager, true)

        onboard_get_started.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

    class OnBoardPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

        var images = arrayOf(R.drawable.ic_walking_person, R.drawable.ic_map)
        var titles = arrayOf(R.string.directions, R.string.nearby_places)
        var descs = arrayOf(R.string.directions_desc, R.string.nearby_places_desc)

        override fun getItem(position: Int): Fragment {
            return OnBoardFragment.newInstance(
                images[position],
                titles[position],
                descs[position])
        }

        override fun getCount(): Int {
            return images.size
        }

    }

}
