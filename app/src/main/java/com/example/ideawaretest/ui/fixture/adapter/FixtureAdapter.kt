package com.example.ideawaretest.ui.fixture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ideawaretest.R
import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.databinding.ItemFixtureBinding
import com.example.ideawaretest.databinding.ItemResultBinding
import com.example.ideawaretest.ui.fixture.adapter.viewholder.FixtureVH
import com.example.ideawaretest.ui.fixture.adapter.viewholder.HeaderVH
import com.example.ideawaretest.ui.fixture.adapter.viewholder.ResultVH
import com.example.ideawaretest.ui.fixture.adapter.viewholder.base.BaseVH

const val HEADER_RESULT = 1
const val ITEM_RESULT = 0

class FixtureAdapter(private val isResult: Boolean = false) : RecyclerView.Adapter<BaseVH>(), Filterable {

    private var listData: List<DataResponse> = emptyList()
    private var filteredData: List<DataResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == HEADER_RESULT) {
            val itemView = inflater.inflate(R.layout.item_header_result, parent, false)
            HeaderVH(itemView)
        } else {
            if (isResult) {
                val binding =
                    DataBindingUtil.inflate<ItemResultBinding>(inflater, R.layout.item_result, parent, false)
                ResultVH(binding)
            } else {
                val binding =
                    DataBindingUtil.inflate<ItemFixtureBinding>(inflater, R.layout.item_fixture, parent, false)
                FixtureVH(binding)
            }
        }
    }

    override fun getItemCount() = filteredData.size

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        holder.setData(filteredData[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (filteredData[position].isHeader) HEADER_RESULT else ITEM_RESULT
    }

    fun setListData(listData: List<DataResponse>) {
        this.listData = listData
        this.filteredData = listData
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val filterString = charSequence.toString()
                val results = FilterResults()
                val filterDataList = arrayListOf<DataResponse>()
                if (filterString.isNotEmpty()) {
                    for (data in listData) {
                        if (data.competitionStage.competition.name == filterString) {
                            filterDataList.add(data)
                        }
                    }
                    results.values = filterDataList
                } else {
                    results.values = listData
                }

                return results
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredData = filterResults.values as List<DataResponse>
                notifyDataSetChanged()
            }
        }
    }
}