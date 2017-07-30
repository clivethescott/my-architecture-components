package org.clivethescott.apps.retrofit_rxjava

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import org.clivethescott.apps.retrofit_rxjava.architecture.viewmodel.CategoriesViewModel


class MainActivity : LifecycleActivity() {

    lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java)
        lifecycle.addObserver(categoriesViewModel)

        categoriesViewModel.categories.observe(this, Observer<List<Category>> { categories ->

            categories?.let {

                Log.i(TAG, "Received ${it.size} categories in Main activity")
            }
        })

    }

    override fun onStop() {
        super.onStop()
        lifecycle.removeObserver(categoriesViewModel)

    }

    companion object {
        val TAG = "MainActv"
    }
}
