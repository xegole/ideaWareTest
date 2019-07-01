package com.example.ideawaretest.data.model

import com.example.ideawaretest.utils.AppConstants

data class DataScore(
    val home: Int = AppConstants.INT_ZERO,
    val away: Int = AppConstants.INT_ZERO,
    val winner: String = AppConstants.EMPTY_STRING,
    var homeWinner: Boolean = false
)