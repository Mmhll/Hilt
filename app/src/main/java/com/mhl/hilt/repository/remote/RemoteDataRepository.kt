package com.mhl.hilt.repository.remote

import com.mhl.hilt.dataclasses.profession.Profession
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataRepository @Inject constructor(
    private val remoteService: RemoteService
) {
    suspend fun getProfession(professionName: String): Flow<Profession> {
        return flow {
            val data = remoteService.getProfession(professionName)
            emit(data)
        }.flowOn(Dispatchers.IO)
    }
}