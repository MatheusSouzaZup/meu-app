package br.com.meuape.view

import android.text.method.ScrollingMovementMethod
import br.com.meuape.R
import br.com.meuape.databinding.FragmentTermsBinding
import br.com.meuape.viewmodel.BaseViewModel
import hands.android.webmotors.mvvm.view.BaseFragment

class TermsFragment : BaseFragment<FragmentTermsBinding, BaseViewModel>() {
    override val fragmentLayout: Int = R.layout.fragment_terms

    override val viewModelClass: Class<BaseViewModel>? = BaseViewModel::class.java

    companion object {
        @JvmStatic
        fun newInstance(): TermsFragment {
            return TermsFragment()
        }
    }

    override fun init() {
        bind.wvTerms.movementMethod = ScrollingMovementMethod()
    }
}