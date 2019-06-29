package br.com.meuape.view.home

import br.com.meuape.view.InfoFragment
import br.com.meuape.view.IntroFragment
import br.com.meuape.view.TermsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    abstract fun HomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun IntroFragment(): IntroFragment

    @ContributesAndroidInjector
    abstract fun InfoFragment(): InfoFragment

    @ContributesAndroidInjector
    abstract fun TermsFragment(): TermsFragment

}