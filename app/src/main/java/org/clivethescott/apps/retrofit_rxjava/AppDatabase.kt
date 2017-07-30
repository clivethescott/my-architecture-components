package org.clivethescott.apps.retrofit_rxjava

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import org.clivethescott.apps.retrofit_rxjava.category.Category
import org.clivethescott.apps.retrofit_rxjava.category.CategoryDAO
import org.clivethescott.apps.retrofit_rxjava.utils.RoomTypeConverters

/**
 * Created by scott on 30/07/2017.
 */
@Database(entities = arrayOf(Category::class), version = 1, exportSchema = true)
@TypeConverters(value = RoomTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDAO(): CategoryDAO
}