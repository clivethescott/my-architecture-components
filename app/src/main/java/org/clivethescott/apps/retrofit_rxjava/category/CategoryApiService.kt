package org.clivethescott.apps.retrofit_rxjava.category

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by scott on 30/07/2017.
 */
interface CategoryApiService {

    @GET("api/v1/facilityCategory/list")
    fun findAll(): Single<List<Category>>
}