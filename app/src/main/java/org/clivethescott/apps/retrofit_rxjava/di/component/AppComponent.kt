package org.clivethescott.apps.retrofit_rxjava.di.component

import dagger.Component
import org.clivethescott.apps.retrofit_rxjava.category.CategoryViewModel
import org.clivethescott.apps.retrofit_rxjava.di.module.AppModule
import org.clivethescott.apps.retrofit_rxjava.di.module.LocalDataModule
import org.clivethescott.apps.retrofit_rxjava.di.module.NetworkModule
import org.clivethescott.apps.retrofit_rxjava.di.module.RemoteDataModule
import javax.inject.Singleton

/**
 * Created by scott on 30/07/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, RemoteDataModule::class, LocalDataModule::class))
interface AppComponent {

    fun inject(target: CategoryViewModel)
}