package com.example.ideawaretest.ui.fixture.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.ideawaretest.R
import com.example.ideawaretest.databinding.FragmentFixtureBinding
import com.example.ideawaretest.ui.fixture.adapter.FixtureAdapter
import com.example.ideawaretest.ui.fixture.viewmodel.FixtureViewModel

class FixtureFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(FixtureViewModel::class.java)
    }

    private val adapter by lazy {
        FixtureAdapter()
    }

    private var binding: FragmentFixtureBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentFixtureBinding>(inflater, R.layout.fragment_fixture, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        binding?.recyclerFixtures?.adapter = adapter
        binding?.recyclerFixtures?.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        binding?.spinnerCompetition?.onItemSelectedListener = this

        viewModel.successResults.observe(this, Observer {
            adapter.setListData(it)
        })

        viewModel.spinnerList.observe(this, Observer { list ->
            context?.let {
                val spinnerAdapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, list)
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding?.spinnerCompetition?.adapter = spinnerAdapter
            }
        })

        viewModel.loadFixtures()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        adapter.filter.filter(parent?.getItemAtPosition(position) as String)
    }

    companion object {
        fun instance() = FixtureFragment()
    }
}