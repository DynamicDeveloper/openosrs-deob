package org.runestar.client.plugins.dev

import org.runestar.client.api.Fonts
import org.runestar.client.api.util.DisposablePlugin
import org.runestar.client.game.api.SceneTile
import org.runestar.client.game.api.live.Game
import org.runestar.client.game.api.live.Canvas
import org.runestar.client.game.api.live.Scene
import org.runestar.client.plugins.spi.PluginSettings
import java.awt.Color

class TileHeightDebug : DisposablePlugin<PluginSettings>() {

    override val defaultSettings = PluginSettings()

    override fun onStart() {
        add(Canvas.repaints.subscribe { g ->
            g.font = Fonts.PLAIN_12
            g.color = Color.WHITE
            val fontSize = g.font.size

            for (x in 0 until Scene.SIZE) {
                for (y in 0 until Scene.SIZE) {
                    val tile = SceneTile(x, y, Game.plane)
                    val height = Scene.getHeight(tile)
                    val center = tile.center.toScreen()
                    if (center != null) {
                        g.drawString(height.toString(), center.x - fontSize, center.y - fontSize)
                    }
                }
            }
        })
    }
}