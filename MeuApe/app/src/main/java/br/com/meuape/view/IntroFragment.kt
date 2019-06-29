package br.com.meuape.view

import br.com.meuape.R
import br.com.meuape.databinding.FragmentIntroBinding
import br.com.meuape.view.home.HomeActivity
import br.com.meuape.viewmodel.BaseViewModel
import hands.android.webmotors.mvvm.view.BaseFragment

class IntroFragment : BaseFragment<FragmentIntroBinding, BaseViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_intro

    override val viewModelClass: Class<BaseViewModel>? = BaseViewModel::class.java

    companion object {
        @JvmStatic
        fun newInstance(): IntroFragment {
            return IntroFragment()
        }
    }

    override fun init() {
        bind.btOk.setOnClickListener {
            val homeActivity = activity as HomeActivity
            homeActivity.replaceFragment(InfoFragment.newInstance())
        }
    }
}