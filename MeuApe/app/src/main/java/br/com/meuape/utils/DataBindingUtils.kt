package br.com.meuape.utils

import android.databinding.BindingAdapter
import br.com.zup.multistatelayout.MultiStateLayout

/**
 * Created by rafaelneiva on 02/10/18.
 */
object DataBindingUtils {

    @JvmStatic
    @BindingAdapter("msl_state")
    fun setState(multiStateLayout: MultiStateLayout, state: MultiStateLayout.State) {
        multiStateLayout.setState(state)
    }

//    @JvmStatic
//    @BindingAdapter("img_url")
//    fun setPicassoImage(imageView: ImageView, imgUrl: String?) {
//        if (imgUrl == null) return
//        Picasso.with(g)
//            .load(imgUrl)
//            .into(imageView)
//    }
}
