package org.clivethescott.apps.retrofit_rxjava.architecture.repository

import io.reactivex.Single
import org.clivethescott.apps.retrofit_rxjava.Category

/**
 * Created by scott on 30/07/2017.
 */
interface CategoryRepository {

    fun findAll() : Single<List<Category>>
}