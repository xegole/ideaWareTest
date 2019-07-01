package com.example.ideawaretest.data.repository

import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.data.sources.TeamsDataSource

class TeamRepository(private val teamDataSource: TeamsDataSource) : TeamsDataSource {

    override fun listAllFixtures(success: (List<DataResponse>) -> Unit, failure: () -> Unit) {
        teamDataSource.listAllFixtures(success, failure)
    }

    override fun listAllResults(success: (List<DataResponse>) -> Unit, failure: () -> Unit) {
        teamDataSource.listAllResults(success, failure)
    }

    override fun onDispose() {
        teamDataSource.onDispose()
    }
}