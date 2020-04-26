package de.oakim.picture_maker.pictures

import kotlin.math.PI

object TemplatePicture : Picture("Template") {
    override fun draw() {
        with(context2D) {
            font = "24px Comic Sans MS"

            var r = 50.0

            var x = 10.0
            var y = 10.0

            beginPath()
            figures(x, y, r)
            stroke()
            closePath()

            x += 300.0
            y += 0

            beginPath()
            figures(x, y, r)
            fill()
            closePath()

            x += 300.0
            y += 0

            strokeText("This is stroke text", x, y + 20.0)
            fillText("This is fill text", x, y + 70.0)

            y += 100
            fillStyle = "red"
            fillRect(x, y, 150.0, 80.0)

            y += 100
            fillStyle = "#33CCAA"
            fillRect(x, y, 150.0, 80.0)

            y += 100
            var gradient = createLinearGradient(x, y, x + 150, y)
            gradient.addColorStop(0.0, "black")
            gradient.addColorStop(0.5, "green")
            gradient.addColorStop(1.0, "white")
            fillStyle = gradient
            fillRect(x, y, 150.0, 80.0)

            y += 100
            gradient = createLinearGradient(x, y, x + 150, y + 80)
            gradient.addColorStop(0.0, "black")
            gradient.addColorStop(0.5, "red")
            gradient.addColorStop(1.0, "white")
            fillStyle = gradient
            fillRect(x, y, 150.0, 80.0)

            y += 100
            gradient = createRadialGradient(x + 75, y, 10.0, x + 75, y, 100.0)
            gradient.addColorStop(0.0, "black")
            gradient.addColorStop(0.5, "yellow")
            gradient.addColorStop(1.0, "white")
            fillStyle = gradient
            fillRect(x, y, 150.0, 80.0)

            x += 300.0
            y = 110.0
            fillStyle = "magenta"
            shadowColor = "black"
            shadowBlur = 20.0
            fillRect(x, y, 150.0, 80.0)

            y += 100
            shadowColor = "red"
            shadowOffsetX = 10.0
            shadowOffsetY = 10.0
            fillRect(x, y, 150.0, 80.0)
        }
    }

    fun figures(startX: Double, startY: Double, r: Double) {
        with(context2D) {
            // rect
            var x = startX
            var y = startY
            val h = 2 * r
            val w = 4 * r

            rect(x, y, w, h)

            // circle
            x += 0
            y += h + r + 20
            moveTo(x + 2 * r, y)
            arc(x + r, y, r, 0.0, 2 * PI)

            // sector
            x += 2 * r + 20
            y += 0
            moveTo(x + r, y)
            arc(x + r, y, r, 0.0, 3 * PI / 2)
            lineTo(x + r, y)

            // ellipse
            x = startX + 2 * r
            y += 2 * r + 20
            moveTo(x, y)
            ellipse(x, y, 2 * r, r, 0.0, 0.0, 13 * PI / 8)
            lineTo(x, y)

            // lines
            x = startX
            y += r + 20
            moveTo(x, y)
            quadraticCurveTo(x + 10, y + 50, x + 200, y)

            x = startX
            y += 50
            moveTo(x, y)
            bezierCurveTo(x + 50, y + 100, x + 150, y - 50, x + 200, y)

            // polygon
            x = startX
            y += 50
            moveTo(x, y)
            lineTo(x + w, y)
            arc(x + w, y + r, r, 3 * PI / 2, PI / 2)
            bezierCurveTo(x + w / 2, y + 2 * r, x + w / 2, y + 2 * r - 50, x, y + 2 * r)
            bezierCurveTo(x + 10, y + 2 * r - 10, x + 10, y + 10, x, y)
        }
    }
}