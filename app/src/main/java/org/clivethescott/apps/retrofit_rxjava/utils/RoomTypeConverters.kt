package org.clivethescott.apps.retrofit_rxjava.utils

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by scott on 30/07/2017.
 */
class RoomTypeConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}