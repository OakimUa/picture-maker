package de.oakim.picture_maker.pictures

import kotlin.math.cos
import kotlin.math.sin

object AnimatedTemplate : AnimatedPicture("Animated Tamplate") {
    var x = 300.0
    var y = 300.0
    var r = 250.0
    var angle = 0.0

    val cx: Double
        get() = x + sin(angle) * r

    val cy: Double
        get() = x + cos(angle) * r

    override fun init() {
        angle = 0.0
        with(context2D) {
            console.log("$cx:$cy")
            moveTo(cx, cy)
        }
    }

    override fun calculate() {
        angle += 1.5
    }

    override fun drawSlide() {
        with(context2D) {
            console.log("$cx:$cy")
            lineTo(cx, cy)
            stroke()
        }
    }
}