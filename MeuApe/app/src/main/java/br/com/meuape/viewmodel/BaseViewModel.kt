package br.com.meuape.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean


open class BaseViewModel protected constructor() : ViewModel() {

    var showLoading = ObservableBoolean(false)

}