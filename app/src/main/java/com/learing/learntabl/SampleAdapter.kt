package com.learing.learntabl

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.learing.learntabl.done.FragmentThree
import com.learing.learntabl.home.FragmentOne
import com.learing.learntabl.important.FragmentTwo

class SampleAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment = when(position) {
        0 -> FragmentOne.newInstance()
        1 -> FragmentTwo.newInstance()
        2 -> FragmentThree.newInstance()
        else -> null
    }!!

    override fun getPageTitle(position: Int): CharSequence? = when(position) {
        0 -> "Home"
        1 -> "Important"
        2 -> "Done"
        else -> ""
    }

    override fun getCount(): Int = 3

}