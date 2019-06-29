package hands.android.webmotors.mvvm.di.builders

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.meuape.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hands.android.webmotors.mvvm.di.ViewModelKey
import hands.android.webmotors.mvvm.viewmodel.*

/**
 * Created by rafaelneiva on 12/06/18.
 */

@Module
abstract class ViewModelBuilder {

    // Garage
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindSavedViewModel(homeViewModel: HomeViewModel): ViewModel


    // ViewModel Factory
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}
