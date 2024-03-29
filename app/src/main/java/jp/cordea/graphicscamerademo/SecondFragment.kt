package jp.cordea.graphicscamerademo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animateButton.setOnClickListener {
            startAnimation()
        }
    }

    private fun startAnimation() {
        imageView.startAnimation(
            RotationAnimation(0f, 180f, imageView.width / 2f, imageView.height / 2f)
                .apply {
                    duration = 1000L
                }
        )
    }
}
