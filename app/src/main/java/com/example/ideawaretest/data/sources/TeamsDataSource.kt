package com.example.ideawaretest.data.sources

import com.example.ideawaretest.data.responses.DataResponse

interface TeamsDataSource {

    fun listAllFixtures(success: (List<DataResponse>) -> Unit, failure: () -> Unit)

    fun listAllResults(success: (List<DataResponse>) -> Unit, failure: () -> Unit)

    fun onDispose()
}