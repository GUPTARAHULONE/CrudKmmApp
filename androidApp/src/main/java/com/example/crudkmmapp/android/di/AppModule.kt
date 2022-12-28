package com.example.crudkmmapp.android.di

import android.app.Application
import com.example.crudkmmapp.data.info.InfoDataSourceImpl
import com.example.crudkmmapp.data.local.InfoDatabaseDriverFactory
import com.example.crudkmmapp.db.InfoDatabase
import com.example.crudkmmapp.domain.info.InfoDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return InfoDatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): InfoDataSource {
        return InfoDataSourceImpl(InfoDatabase(driver))
    }
}