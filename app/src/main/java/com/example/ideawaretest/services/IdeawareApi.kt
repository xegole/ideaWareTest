package com.example.ideawaretest.services

import com.example.ideawaretest.data.responses.DataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface IdeawareApi {

    @GET("results.json")
    fun getResults(): Observable<List<DataResponse>>

    @GET("fixtures.json")
    fun getFixtures(): Observable<List<DataResponse>>
}