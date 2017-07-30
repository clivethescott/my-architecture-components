package org.clivethescott.apps.retrofit_rxjava.category

import android.arch.lifecycle.LiveData
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.clivethescott.apps.retrofit_rxjava.utils.DisposableDataSource

/**
 * Created by scott on 30/07/2017.
 */
class CategoryLiveData(val categoriesRepository: CategoryRepository) :
        LiveData<List<Category>>(), DisposableDataSource {

    private var categoriesDisposable: Disposable? = null

    init {

        fetchData()
    }

    fun fetchData() {

        categoriesDisposable = categoriesRepository.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(

                        onNext = {
                            Log.i(TAG, "Received data $it")
                            postValue(it)
                        },
                        onError = { err ->

                            Log.e(TAG, err.toString())
                            err.message?.let {

                                Log.e(TAG, "An error occurred while trying to retrieve data $it")
                            }
                        }
                )

    }


    override fun dispose() {
        categoriesDisposable?.dispose()
    }

    companion object {
        val TAG = "CatLiveData"
    }

}