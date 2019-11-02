package jp.cordea.graphicscamerademo

import android.animation.ObjectAnimator
import android.graphics.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            startAnimation()
        }
    }

    private fun startAnimation() {
        val camera = Camera()
        val matrix = background.imageMatrix
        ObjectAnimator.ofFloat(0f, 50f)
            .apply {
                duration = 5000L
                addUpdateListener {
                    val value = it.animatedValue as Float
                    camera.save()
                    camera.translate(0f, 0f, value * 10)
                    camera.rotateY(value)

                    camera.getMatrix(matrix)
                    background.imageMatrix = matrix
                    camera.restore()
                }
            }
            .start()
    }
}
