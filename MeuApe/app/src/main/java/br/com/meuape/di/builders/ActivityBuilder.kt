package br.com.meuape.di.builders

import br.com.meuape.view.home.HomeActivity
import br.com.meuape.view.home.HomeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import hands.android.webmotors.mvvm.di.Activity


@Module
abstract class ActivityBuilder {

//    //Home
//    @Activity
//    @ContributesAndroidInjector
//    abstract fun bindHomeActivity(): HomeActivity
//

    @Activity
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindHomeActivity(): HomeActivity


}