package io.sadu.common

import kotlin.time.Duration

fun Duration.toBukkitTicks(): Long {
    return this.inWholeMilliseconds / 50
}