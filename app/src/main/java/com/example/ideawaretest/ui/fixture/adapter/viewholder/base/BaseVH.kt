package com.example.ideawaretest.ui.fixture.adapter.viewholder.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ideawaretest.data.responses.DataResponse

abstract class BaseVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun setData(dataResponse: DataResponse)
}