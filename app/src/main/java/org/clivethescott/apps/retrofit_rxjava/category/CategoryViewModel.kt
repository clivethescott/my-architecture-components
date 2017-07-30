package org.clivethescott.apps.retrofit_rxjava.category

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import org.clivethescott.apps.retrofit_rxjava.MyApplication
import javax.inject.Inject


/**
 * Created by scott on 30/07/2017.
 */
class CategoryViewModel : ViewModel(), LifecycleObserver {

    @Inject lateinit var categoriesRepository: CategoryRepository
    val categories: CategoryLiveData

    init {

        MyApplication.injector.inject(this)

        categories = CategoryLiveData(categoriesRepository)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

        Log.i(TAG, "Disposing of categories")
        categories.dispose()
    }

    companion object {
        val TAG = "CatViewModel"
    }

}