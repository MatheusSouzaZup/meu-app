package br.com.meuape.di.app

import android.app.Application
import br.com.meuape.MeuApeApplication
import br.com.meuape.di.builders.ActivityBuilder
import hands.android.webmotors.mvvm.di.builders.ViewModelBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import hands.android.webmotors.mvvm.di.app.ApiServiceModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        RoomModule::class,
        ApiServiceModule::class,
        NetworkModule::class,
        ViewModelBuilder::class,
        ActivityBuilder::class
    ]
)
interface AppComponent {

    fun inject(application: MeuApeApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}