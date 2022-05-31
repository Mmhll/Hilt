package com.mhl.hilt.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mhl.hilt.dataclasses.profession.Profession

@Dao
interface ProfessionDao {
    @Query("SELECT * FROM profession WHERE profession.code = :code")
    suspend fun getProfession(code : String) : Profession

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfession(profession: Profession)
}