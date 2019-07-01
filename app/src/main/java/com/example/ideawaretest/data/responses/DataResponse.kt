package com.example.ideawaretest.data.responses

import com.example.ideawaretest.data.model.CompetitionStage
import com.example.ideawaretest.data.model.DataScore
import com.example.ideawaretest.data.model.DataTeam
import com.example.ideawaretest.data.model.DataVenue
import com.example.ideawaretest.utils.AppConstants
import java.util.*

data class DataResponse(
    val id: Int = AppConstants.INT_ZERO,
    val type: String = AppConstants.EMPTY_STRING,
    val homeTeam: DataTeam = DataTeam(),
    val awayTeam: DataTeam = DataTeam(),
    var date: Date = Date(),
    val competitionStage: CompetitionStage = CompetitionStage(),
    val venue: DataVenue = DataVenue(),
    val state: String = AppConstants.EMPTY_STRING,
    val score: DataScore = DataScore(),
    var isHeader: Boolean = false
)