package org.clivethescott.apps.retrofit_rxjava.di.module

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import org.clivethescott.apps.retrofit_rxjava.AppDatabase
import org.clivethescott.apps.retrofit_rxjava.BuildConfig
import org.clivethescott.apps.retrofit_rxjava.category.CategoryDAO
import javax.inject.Singleton


/**
 * Created by scott on 30/07/2017.
 */
@Module(includes = arrayOf(AppModule::class))
class LocalDataModule {

    @Singleton @Provides
    fun provideDatabase(context: Context): AppDatabase {

        val dbName = BuildConfig.DB_NAME
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()
    }

    @Singleton @Provides
    fun provideCategoryDAO(db: AppDatabase): CategoryDAO {

        return db.categoryDAO()
    }
}