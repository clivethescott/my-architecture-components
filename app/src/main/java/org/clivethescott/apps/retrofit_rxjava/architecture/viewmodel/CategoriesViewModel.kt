package org.clivethescott.apps.retrofit_rxjava.architecture.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import org.clivethescott.apps.retrofit_rxjava.architecture.livedata.CategoriesLiveData


/**
 * Created by scott on 30/07/2017.
 */
class CategoriesViewModel : ViewModel(), LifecycleObserver {

    val categories = CategoriesLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

        Log.i(TAG, "Disposing of categories")
        categories.dispose()
    }

    companion object {
        val TAG = "CatViewModel"
    }

}