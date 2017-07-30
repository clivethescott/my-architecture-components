package org.clivethescott.apps.retrofit_rxjava.category

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by scott on 30/07/2017.
 */
@Dao
interface CategoryDAO {

    @Query("SELECT * FROM category")
    fun findAll(): Flowable<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg categories: Category): Array<Long>

    @Delete
    fun delete(category: Category)
}