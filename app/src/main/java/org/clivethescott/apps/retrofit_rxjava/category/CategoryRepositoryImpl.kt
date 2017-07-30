package org.clivethescott.apps.retrofit_rxjava.category

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by scott on 30/07/2017.
 */
class CategoryRepositoryImpl(val categoryApiService: CategoryApiService,
                             val categoryDAO: CategoryDAO) : CategoryRepository {

    override fun findAll(): Flowable<List<Category>> {

        fetchAndUpdateCategoriesFromNetwork()

        return categoryDAO.findAll()
    }

    override fun insertAll(categories: List<Category>): Completable {

        val rawCategoriesCount = categories.size

        return Completable.create {

            val insertedCategoriesCount = categoryDAO.insertAll(*categories.toTypedArray()).size

            if (insertedCategoriesCount == rawCategoriesCount) {

                Log.i(TAG, "Inserted $insertedCategoriesCount categories successfully")
                it.onComplete()

            } else {

                it.onError(IllegalStateException("Insert failed expected $rawCategoriesCount " +
                        "but got $insertedCategoriesCount"))
            }

        }.subscribeOn(Schedulers.io())
    }

    private fun fetchAndUpdateCategoriesFromNetwork() {

        categoryApiService.findAll()
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onSuccess = {
                            executeCategoriesUpdate(it)
                        },
                        onError = {
                            Log.e(TAG, "Unable to fetch categories from network")
                        }
                )
    }


    private fun executeCategoriesUpdate(categories: List<Category>) {

        Log.i(TAG, "Updating categories in DB")

        insertAll(categories)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = {
                            Log.i(TAG, "Categories updated")
                        },
                        onError = {
                            Log.e(TAG, "Error updating categories ${it.message}")
                        }
                )
    }

    companion object {
        val TAG = "CategoryRepoImpl"
    }
}