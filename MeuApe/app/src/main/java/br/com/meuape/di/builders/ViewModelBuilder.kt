package br.com.meuape.di.builders

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.meuape.viewmodel.HomeViewModel
import br.com.meuape.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import br.com.meuape.di.ViewModelKey

/**
 * Created by rafaelneiva on 12/06/18.
 */

@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindSavedViewModel(homeViewModel: HomeViewModel): ViewModel


    // ViewModel Factory
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}
