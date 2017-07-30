package org.clivethescott.apps.retrofit_rxjava.di.module

import dagger.Module
import dagger.Provides
import org.clivethescott.apps.retrofit_rxjava.category.CategoryApiService
import org.clivethescott.apps.retrofit_rxjava.category.CategoryDAO
import org.clivethescott.apps.retrofit_rxjava.category.CategoryRepositoryImpl
import org.clivethescott.apps.retrofit_rxjava.category.CategoryRepository
import javax.inject.Singleton

/**
 * Created by scott on 30/07/2017.
 */
@Module(includes = arrayOf(NetworkModule::class))
class RemoteDataModule {

    @Singleton @Provides
    fun provideCategoryRepository(categoryApiService: CategoryApiService,
                                  categoryDAO: CategoryDAO): CategoryRepository {

        return CategoryRepositoryImpl(categoryApiService, categoryDAO)
    }
}