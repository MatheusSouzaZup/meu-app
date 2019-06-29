package br.com.meuape.di.app

import hands.android.webmotors.mvvm.room.AppDatabase
import hands.android.webmotors.mvvm.room.example.ExampleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    internal fun providesRecentLocationSearchDao(appDb: AppDatabase): ExampleDao {
        return appDb.exampleDao()
    }
}