package org.clivethescott.apps.retrofit_rxjava.category

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by scott on 30/07/2017.
 */
@Entity
data class Category(
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "category_name") val name: String
)
