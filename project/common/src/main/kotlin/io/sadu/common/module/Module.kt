package io.sadu.common.module

import io.sadu.common.SaduApplication
import kotlin.reflect.KClass

interface Module<A: SaduApplication> {
    val name: String
    val dependsOn: Set<KClass<out Module<A>>>

    suspend fun onEnable(app: A)
    suspend fun onDisable(app: A)
}