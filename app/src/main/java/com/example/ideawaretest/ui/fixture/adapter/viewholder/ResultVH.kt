package com.example.ideawaretest.ui.fixture.adapter.viewholder

import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.databinding.ItemResultBinding
import com.example.ideawaretest.ui.fixture.adapter.viewholder.base.BaseVH

class ResultVH(private val binding: ItemResultBinding) : BaseVH(binding.root) {

    override fun setData(dataResponse: DataResponse) {
        dataResponse.score.homeWinner = dataResponse.score.winner == "home"
        binding.dataResponse = dataResponse
        binding.executePendingBindings()
    }
}