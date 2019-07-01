package com.example.ideawaretest.data.remote

import com.example.ideawaretest.data.responses.DataResponse
import com.example.ideawaretest.data.sources.TeamsDataSource
import com.example.ideawaretest.services.IdeawareApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TeamsDataSourceImpl(private val ideawareApi: IdeawareApi) : TeamsDataSource {

    private var disposable: Disposable? = null

    override fun listAllFixtures(success: (List<DataResponse>) -> Unit, failure: () -> Unit) {
        disposable = ideawareApi.getFixtures()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                success(response)
            }, {
                it.printStackTrace()
                failure()
            })
    }

    override fun listAllResults(success: (List<DataResponse>) -> Unit, failure: () -> Unit) {
        disposable = ideawareApi.getResults()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                success(response)
            }, {
                it.printStackTrace()
                failure()
            })
    }

    override fun onDispose() {
        disposable?.dispose()
    }
}