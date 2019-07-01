package com.example.ideawaretest.services

import com.example.ideawaretest.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class IdeawareService {

    companion object {
        private var retrofit: Retrofit? = null

        private fun getInstance(): Retrofit? {
            return if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofit
            } else {
                retrofit
            }
        }

        fun getService(): IdeawareApi = getInstance()!!.create(IdeawareApi::class.java)
    }
}