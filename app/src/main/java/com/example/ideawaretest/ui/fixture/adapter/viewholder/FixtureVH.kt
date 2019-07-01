package com.example.ideawaretest.ui.fixture.adapter.viewholder

import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.databinding.ItemFixtureBinding
import com.example.ideawaretest.ui.fixture.adapter.viewholder.base.BaseVH

class FixtureVH(private val binding: ItemFixtureBinding) : BaseVH(binding.root) {

    override fun setData(dataResponse: DataResponse) {
        binding.dataResponse = dataResponse
        binding.executePendingBindings()
    }
}