package com.example.ideawaretest.data.model

import com.example.ideawaretest.utils.AppConstants

data class DataTeam(
    val id: Int = AppConstants.INT_ZERO,
    val name: String = AppConstants.EMPTY_STRING,
    val shortName: String = AppConstants.EMPTY_STRING,
    val abbr: String = AppConstants.EMPTY_STRING,
    val alias: String = AppConstants.EMPTY_STRING
)