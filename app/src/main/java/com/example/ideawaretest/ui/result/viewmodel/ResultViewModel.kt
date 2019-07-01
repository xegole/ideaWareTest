package com.example.ideawaretest.ui.result.viewmodel

import android.app.Application
import android.text.format.DateFormat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.ideawaretest.data.remote.TeamsDataSourceImpl
import com.example.ideawaretest.data.repository.TeamRepository
import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.services.IdeawareService
import com.example.ideawaretest.utils.AppConstants
import java.text.SimpleDateFormat
import java.util.*

class ResultViewModel(application: Application) : AndroidViewModel(application) {

    private val ideawareService by lazy {
        IdeawareService.getService()
    }

    private val repository by lazy {
        TeamRepository(TeamsDataSourceImpl(ideawareService))
    }

    val successResults = MutableLiveData<List<DataResponse>>()
    val spinnerList = MutableLiveData<List<String>>()

    fun loadResults() {
        repository.listAllResults({
            groupData(it)
        }, {

        })
    }

    private fun groupData(list: List<DataResponse>) {
        val listMutable = ArrayList<DataResponse>()
        val mapCompetition = list.groupBy { it.competitionStage.competition.name }
        val map = list.sortedBy { it.date }.groupBy {
            val dateString = DateFormat.format(AppConstants.FORMAT_DATE, it.date) as String
            val date = SimpleDateFormat(AppConstants.FORMAT_DATE, Locale.getDefault()).parse(dateString)
            date
        }

        for (entry in map.entries) {
            val data = DataResponse()
            data.date = entry.key
            data.isHeader = true
            listMutable.add(data)
            listMutable.addAll(entry.value)
        }

        val listCompetition = ArrayList<String>()
        listCompetition.add(AppConstants.EMPTY_STRING)
        listCompetition.addAll(ArrayList(mapCompetition.keys))
        spinnerList.value = listCompetition
        successResults.value = listMutable
    }

}