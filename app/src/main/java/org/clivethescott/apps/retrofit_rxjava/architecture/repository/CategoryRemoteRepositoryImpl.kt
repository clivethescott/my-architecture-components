package org.clivethescott.apps.retrofit_rxjava.architecture.repository

import io.reactivex.Single
import org.clivethescott.apps.retrofit_rxjava.Category
import org.clivethescott.apps.retrofit_rxjava.CategoryService
import retrofit2.Retrofit

/**
 * Created by scott on 30/07/2017.
 */
class CategoryRemoteRepositoryImpl(val retrofit: Retrofit) : CategoryRepository {

    override fun findAll(): Single<List<Category>> {

        return retrofit.create(CategoryService::class.java).findAll()
    }
}