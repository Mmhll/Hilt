package com.mhl.hilt.di

import android.content.Context
import androidx.room.Room
import com.mhl.hilt.repository.local.ProfessionDao
import com.mhl.hilt.repository.local.ProfessionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class MainLocalModule {

    @Provides
    @Named("DATABASE_NAME")
    fun providesDatabaseName(): String = "Profession"

    @Provides
    @Singleton
    fun providesProfessionDao(professionDatabase: ProfessionDatabase): ProfessionDao =
        professionDatabase.professionDao()

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext
        context: Context,
        @Named("DATABASE_NAME")
        name: String
    ) = Room.databaseBuilder(
        context,
        ProfessionDatabase::class.java,
        name
    ).build()
}