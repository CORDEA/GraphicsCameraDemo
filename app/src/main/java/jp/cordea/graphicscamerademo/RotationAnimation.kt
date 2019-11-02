package jp.cordea.graphicscamerademo

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.Transformation

class RotationAnimation(
    private val from: Float,
    private val to: Float,
    private val centerX: Float,
    private val centerY: Float
) : Animation() {
    private lateinit var camera: Camera

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        this.camera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        super.applyTransformation(interpolatedTime, t)
        val matrix = t.matrix

        camera.save()

        camera.translate(0f, 0f, 500f * interpolatedTime)
        camera.rotateY((to - from) * interpolatedTime)

        camera.getMatrix(matrix)
        camera.restore()

        matrix.preTranslate(-centerX, -centerY)
        matrix.postTranslate(centerX, centerY)

    }
}
