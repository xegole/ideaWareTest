package com.example.ideawaretest.ui.fixture.adapter.viewholder

import android.text.format.DateFormat
import android.view.View
import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.ui.fixture.adapter.viewholder.base.BaseVH
import kotlinx.android.synthetic.main.item_header_result.view.*

class HeaderVH(itemView: View) : BaseVH(itemView) {

    override fun setData(dataResponse: DataResponse) {
        val labelHeader = DateFormat.format("MMMM yyyy", dataResponse.date) as String
        itemView.labelHeaderDate.text = labelHeader
    }
}