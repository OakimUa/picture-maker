package de.oakim.picture_maker.pictures

import org.w3c.dom.CanvasRenderingContext2D
import pl.treksoft.kvision.core.Border
import pl.treksoft.kvision.core.BorderStyle
import pl.treksoft.kvision.core.Col
import pl.treksoft.kvision.core.Color
import pl.treksoft.kvision.html.Canvas
import pl.treksoft.kvision.utils.px

abstract class Picture(val title: String) {
    val component = Canvas(canvasWidth = 1600, canvasHeight = 800).apply {
        border = Border(2.px, BorderStyle.DOTTED, Color.name(Col.BLACK))
    }
    protected val context2D: CanvasRenderingContext2D
        get() = component.context2D
    abstract fun draw()
    open fun dispose() {}
}