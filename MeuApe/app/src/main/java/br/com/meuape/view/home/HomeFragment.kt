package br.com.meuape.view.home

import br.com.meuape.R
import br.com.meuape.databinding.FragmentHomeBinding
import br.com.meuape.view.IntroFragment
import br.com.meuape.viewmodel.HomeViewModel
import hands.android.webmotors.mvvm.view.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override val fragmentLayout: Int = R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel>? = HomeViewModel::class.java

    override fun init() {
        bind.btStart.setOnClickListener {
            val homeActivity = activity as HomeActivity
            homeActivity.replaceFragment(IntroFragment.newInstance())
        }
    }
}