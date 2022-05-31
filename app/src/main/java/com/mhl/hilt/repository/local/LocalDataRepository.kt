package com.mhl.hilt.repository.local

import com.mhl.hilt.dataclasses.profession.Profession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocalDataRepository @Inject constructor(private val professionDao: ProfessionDao) {
    suspend fun getProfession(code : String): Flow<Profession> {
        return flow {
            val data = professionDao.getProfession(code)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }
    suspend fun putProfession(profession: Profession) {
        professionDao.insertProfession(profession)
    }
}