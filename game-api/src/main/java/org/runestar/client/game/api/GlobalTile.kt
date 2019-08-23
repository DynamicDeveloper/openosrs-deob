package org.runestar.client.game.api

import org.runestar.client.game.api.live.Scene

data class GlobalTile(val x: Int, val y: Int, val plane: Int) {

    val region get() = Region(x / Region.SIZE, y / Region.SIZE)

    fun toSceneTile(): SceneTile {
        val base = Scene.base
        return SceneTile(x - base.x, y - base.y, plane)
    }

    fun isLoaded(): Boolean {
        val base = Scene.base
        return SceneTile.isLoaded(x - base.x, y - base.y, plane)
    }
}
