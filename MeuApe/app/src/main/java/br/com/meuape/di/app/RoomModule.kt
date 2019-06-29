package br.com.meuape.di.app

import br.com.meuape.room.AppDatabase
import br.com.meuape.room.example.ExampleDao
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