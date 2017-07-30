package org.clivethescott.apps.retrofit_rxjava.di.module

import dagger.Module
import dagger.Provides
import org.clivethescott.apps.retrofit_rxjava.architecture.repository.CategoryRemoteRepositoryImpl
import org.clivethescott.apps.retrofit_rxjava.architecture.repository.CategoryRepository
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by scott on 30/07/2017.
 */
@Module(includes = arrayOf(NetworkModule::class))
class RemoteDataModule {

    @Singleton @Provides
    fun provideCategoryRepository(retrofit: Retrofit): CategoryRepository {

        return CategoryRemoteRepositoryImpl(retrofit)
    }
}