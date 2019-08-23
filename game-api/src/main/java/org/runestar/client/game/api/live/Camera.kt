package org.runestar.client.game.api.live

import org.runestar.client.game.api.Angle
import org.runestar.client.game.api.LocalValue
import org.runestar.client.game.api.Position
import org.runestar.client.game.raw.CLIENT

object Camera {

    val localX: Int get() = CLIENT.cameraX.coerceIn(0, LocalValue.MAX.value)

    val localY: Int get() = CLIENT.cameraZ.coerceIn(0, LocalValue.MAX.value)

    val absoluteHeight: Int get() = CLIENT.cameraY

    val height: Int get() = Scene.getTileHeight(localX, localY, plane) - absoluteHeight

    val plane: Int get() = CLIENT.plane

    val pitch get() = Angle.of(CLIENT.cameraPitch)

    val yaw get() = Angle.of(CLIENT.cameraYaw)

    val position: Position get() = Position(localX, localY, height, plane)

    override fun toString(): String {
        return "Camera(position=$position, pitch=$pitch, yaw=$yaw)"
    }
}