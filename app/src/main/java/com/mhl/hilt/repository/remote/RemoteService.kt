package com.mhl.hilt.repository.remote

import com.mhl.hilt.dataclasses.profession.Profession
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {
    @GET("Professions/{professionName}.json")
    suspend fun getProfession(@Path("professionName") name : String) : Profession
}
