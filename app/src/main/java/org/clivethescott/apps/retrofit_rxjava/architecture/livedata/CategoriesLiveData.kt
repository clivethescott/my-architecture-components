package org.clivethescott.apps.retrofit_rxjava.architecture.livedata

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.clivethescott.apps.retrofit_rxjava.Category
import org.clivethescott.apps.retrofit_rxjava.MyApplication
import org.clivethescott.apps.retrofit_rxjava.architecture.repository.CategoryRepository
import org.clivethescott.apps.retrofit_rxjava.architecture.viewmodel.DisposableDataSource
import javax.inject.Inject

/**
 * Created by scott on 30/07/2017.
 */
class CategoriesLiveData : LiveData<List<Category>>(), DisposableDataSource {

    private var categoriesDisposable: Disposable? = null
    @Inject lateinit var categoriesRepository: CategoryRepository

    init {

        MyApplication.injector.inject(this)
        fetchData()
    }

    fun fetchData() {

        categoriesDisposable = categoriesRepository.findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(

                        onSuccess = {
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