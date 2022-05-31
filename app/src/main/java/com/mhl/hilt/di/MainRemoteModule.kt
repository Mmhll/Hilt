package com.mhl.hilt.di

import com.mhl.hilt.repository.remote.RemoteDataRepository
import com.mhl.hilt.repository.remote.RemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainRemoteModule {

    @Provides
    @Named("BASE_URL")
    fun provideBaseURL(): String = "https://cursach-ee2f0-default-rtdb.firebaseio.com/"

    @Provides
    @Singleton
    fun provideRetrofit(@Named("BASE_URL") BASE_URL: String): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideRemoteService(retrofit: Retrofit): RemoteService =
        retrofit.create(RemoteService::class.java)


    @Provides
    @Singleton
    fun provideDataRepository(service: RemoteService): RemoteDataRepository =
        RemoteDataRepository(service)

}