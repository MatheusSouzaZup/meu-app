package br.com.meuape.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import br.com.meuape.R
import kotlinx.android.synthetic.main.custom_bottom_view.view.*

class BottomView : LinearLayout {
    lateinit var bottomViewOnClickListener: BottomViewOnClickListener
    var soundRunning : Boolean = false

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        FrameLayout.inflate(getContext(), R.layout.custom_bottom_view, this)
        init()
    }

    private fun init() {
        btSound.setOnClickListener {
            if (::bottomViewOnClickListener.isInitialized) {
                bottomViewOnClickListener.onSoundClicked()
                if(soundRunning) {
                    btSound.setImageDrawable(resources.getDrawable(R.drawable.ic_speaker_off))
                }
                else {
                    btSound.setImageDrawable(resources.getDrawable(R.drawable.ic_speaker_on))
                }
            }
        }
    }

    fun setClickListener(bottomViewOnClickListener: BottomViewOnClickListener) {
        this.bottomViewOnClickListener = bottomViewOnClickListener
    }

    interface BottomViewOnClickListener {
        fun onSoundClicked()
    }
}