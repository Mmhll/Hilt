package com.mhl.hilt.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mhl.hilt.dataclasses.profession.Profession

@Database(entities = [Profession::class], version = 1)
abstract class ProfessionDatabase : RoomDatabase() {
    abstract fun professionDao(): ProfessionDao
}