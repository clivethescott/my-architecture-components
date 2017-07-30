package org.clivethescott.apps.retrofit_rxjava.category

import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by scott on 30/07/2017.
 */
interface CategoryRepository {

    fun findAll(): Flowable<List<Category>>

    fun insertAll(categories: List<Category>): Completable
}