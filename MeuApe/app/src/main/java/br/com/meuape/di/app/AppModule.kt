package br.com.meuape.di.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import br.com.meuape.MeuApeApplication
import dagger.Module
import dagger.Provides
import hands.android.webmotors.mvvm.room.AppDatabase
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun providesAppApplication(application: Application): MeuApeApplication {
        return application as MeuApeApplication
    }

    @Provides
    @Singleton
    internal fun providesRoomDb(app: Application): AppDatabase {
        return (app as MeuApeApplication).getAppDb()
    }
}
