package br.com.meuape.view

import br.com.meuape.R
import br.com.meuape.databinding.FragmentInfoBinding
import br.com.meuape.view.home.HomeActivity
import br.com.meuape.viewmodel.BaseViewModel
import hands.android.webmotors.mvvm.view.BaseFragment

class InfoFragment : BaseFragment<FragmentInfoBinding, BaseViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_info

    override val viewModelClass: Class<BaseViewModel>? = BaseViewModel::class.java

    companion object {
        @JvmStatic
        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }

    override fun init() {
        bind.btNext.setOnClickListener {
            var homeActivity = activity as HomeActivity
            homeActivity.replaceFragment(TermsFragment.newInstance())
        }
    }
}