package de.oakim.picture_maker.pictures

import kotlin.browser.window

abstract class AnimatedPicture(title: String, private val timeout: Int = 100): Picture(title) {
    private var job: Int? = null

    override fun draw() {
        init()
        drawSlide()
        job = window.setInterval({
            calculate()
            drawSlide()
        }, timeout)
    }

    abstract fun init()
    abstract fun drawSlide()
    abstract fun calculate()

    override fun dispose() {
        if (job != null)
            window.clearInterval(job!!)
    }
}