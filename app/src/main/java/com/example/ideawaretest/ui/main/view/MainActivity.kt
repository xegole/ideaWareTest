package com.example.ideawaretest.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.ideawaretest.R
import com.example.ideawaretest.databinding.ActivityMainBinding
import com.example.ideawaretest.ui.main.adapter.SectionPagesAdapter
import com.example.ideawaretest.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val adapter by lazy {
        SectionPagesAdapter(this, supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.viewPagerSections.adapter = adapter
        binding.slidingTabs.setupWithViewPager(binding.viewPagerSections)
    }
}
