package br.com.meuape

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import br.com.meuape.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hands.android.webmotors.mvvm.room.AppDatabase
import javax.inject.Inject

class MeuApeApplication : Application(), HasActivityInjector {

    private lateinit var intance: MeuApeApplication
    private lateinit var mAppDb: AppDatabase

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun onCreate() {
        intance = this
        super.onCreate()
        initInjector()
        initRoom()
    }

    private fun initRoom() {
        mAppDb = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "myapp-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    private fun initInjector() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    fun getAppDb(): AppDatabase {
        return mAppDb
    }
}