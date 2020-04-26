package de.oakim.picture_maker

import de.oakim.picture_maker.pictures.AnimatedTemplate
import de.oakim.picture_maker.pictures.Picture
import de.oakim.picture_maker.pictures.TemplatePicture

object Registry {
    val pictures: Array<Picture> = arrayOf(
            TemplatePicture,
            AnimatedTemplate
    )
}