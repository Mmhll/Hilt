package com.mhl.hilt.dataclasses.profession

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mhl.hilt.utils.ArrayListConverter


@Entity(tableName = "profession")
@TypeConverters(ArrayListConverter::class)
data class Profession(
    val about: String? = "",
    val budget: String? = "",
    @PrimaryKey val code: String = "",
    val image: String? = "",
    val name: String? = "",
    @TypeConverters(ArrayListConverter::class)
    val years: ArrayList<Year>? = null
)

