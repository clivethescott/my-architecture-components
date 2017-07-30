package org.clivethescott.apps.retrofit_rxjava

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import org.clivethescott.apps.retrofit_rxjava.category.Category
import org.clivethescott.apps.retrofit_rxjava.category.CategoryViewModel


class MainActivity : LifecycleActivity() {

    lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        lifecycle.addObserver(categoryViewModel)

        categoryViewModel.categories.observe(this, Observer<List<Category>> { categories ->

            categories?.let {

                Log.i(TAG, "Received ${it.size} categories in Main activity")
            }
        })

    }

    override fun onStop() {
        super.onStop()
        lifecycle.removeObserver(categoryViewModel)

    }

    companion object {
        val TAG = "MainActv"
    }
}
