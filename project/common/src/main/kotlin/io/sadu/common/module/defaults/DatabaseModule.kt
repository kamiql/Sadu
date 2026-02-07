package io.sadu.common.module.defaults

import io.sadu.common.SaduApplication
import io.sadu.common.module.Module
import kotlin.reflect.KClass

class DatabaseModule internal constructor() : Module<SaduApplication> {
    override val name: String = "database"
    override val dependsOn: Set<KClass<out Module<SaduApplication>>> = emptySet()

    override suspend fun onEnable(app: SaduApplication) {

    }

    override suspend fun onDisable(app: SaduApplication) {

    }
}