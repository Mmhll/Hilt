package com.mhl.hilt.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mhl.hilt.dataclasses.profession.Year
import java.lang.reflect.Type

class ArrayListConverter {

    @TypeConverter
    fun convertToJson(dataArray: ArrayList<Year>): String {
        return Gson().toJson(dataArray)
    }

    @TypeConverter
    fun convertToArrayList(dataJson: String): ArrayList<Year> {
        val listType: Type = object : TypeToken<ArrayList<Year>>() {}.type
        return Gson().fromJson(dataJson, listType)
    }

}