package com.example.ideawaretest.ui.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ideawaretest.R
import com.example.ideawaretest.ui.fixture.view.FixtureFragment
import com.example.ideawaretest.ui.result.ResultFragment
import com.example.ideawaretest.utils.AppConstants

class SectionPagesAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            AppConstants.FIRST -> FixtureFragment.instance()
            AppConstants.SECOND -> ResultFragment.instance()
            else -> FixtureFragment.instance()
        }
    }

    override fun getCount() = AppConstants.PAGES

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            AppConstants.FIRST -> context.getString(R.string.label_page_fixture)
            AppConstants.SECOND -> context.getString(R.string.label_page_result)
            else -> context.getString(R.string.label_page_fixture)
        }
    }
}