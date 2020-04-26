package de.oakim.picture_maker

import de.oakim.picture_maker.pictures.Picture
import pl.treksoft.kvision.Application
import pl.treksoft.kvision.html.button
import pl.treksoft.kvision.html.div
import pl.treksoft.kvision.i18n.DefaultI18nManager
import pl.treksoft.kvision.i18n.I18n
import pl.treksoft.kvision.i18n.I18n.tr
import pl.treksoft.kvision.navbar.NavbarType
import pl.treksoft.kvision.navbar.nav
import pl.treksoft.kvision.navbar.navLink
import pl.treksoft.kvision.navbar.navbar
import pl.treksoft.kvision.panel.root
import pl.treksoft.kvision.panel.tabPanel
import pl.treksoft.kvision.require
import pl.treksoft.kvision.startApplication
import pl.treksoft.kvision.utils.px

class App : Application() {
    init {
        require("css/kvapp.css")
    }

    override fun start() {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "pl" to require("i18n/messages-pl.json"),
                    "en" to require("i18n/messages-en.json")
                )
            )

        root("kvapp") {
            val mainPanel = div {
                marginTop = 60.px
                marginLeft = 5.px
            }
            var currentPicture: Picture? = null
            navbar(type = NavbarType.FIXEDTOP) {
                nav {
                    Registry.pictures.forEach { picture ->
                        navLink(picture.title).onClick {
                            currentPicture?.dispose()
                            currentPicture = picture
                            mainPanel.removeAll()
                            mainPanel.add(picture.component)
                            picture.draw()
                        }
//                        button(picture.title).onClick {
//                            currentPicture?.dispose()
//                            currentPicture = picture
//                            mainPanel.removeAll()
//                            mainPanel.add(picture.component)
//                            picture.draw()
//                        }
                    }
                }
            }

//            tabPanel {
//                Registry.pictures.forEach {
//                    addTab(it.title, it.component)
//                }
//            }
        }
//        Registry.pictures.forEach { it.draw() }
    }
}

fun main() {
    startApplication(::App)
}
