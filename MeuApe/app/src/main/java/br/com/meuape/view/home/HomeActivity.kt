package br.com.meuape.view.home

import android.media.MediaPlayer
import android.support.v4.app.Fragment
import br.com.meuape.R
import br.com.meuape.databinding.ActivityHomeBinding
import br.com.meuape.viewmodel.HomeViewModel
import br.com.zup.mvvm.view.BaseActivity


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    private lateinit var mediaPlayer: MediaPlayer

    override fun init() {
        addFragment(HomeFragment.newInstance())
        setupSoundtrack()
    }

    private fun setupSoundtrack() {
//        mediaPlayer = MediaPlayer.create(this, R.raw.trilhasonora)
//        mediaPlayer.isLooping = true
//        mediaPlayer.start()

    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment, fragment.tag)
            .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, fragment.tag)
            .addToBackStack(fragment.tag)
            .commit()
    }

    override fun onPause() {
        super.onPause()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.pause()
        }
    }
}