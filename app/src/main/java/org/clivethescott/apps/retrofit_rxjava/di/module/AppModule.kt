package org.clivethescott.apps.retrofit_rxjava.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by scott on 30/07/2017.
 */
@Module
class AppModule(val application: Application) {

    @Provides @Singleton
    fun provideAppContext(): Context = application
}