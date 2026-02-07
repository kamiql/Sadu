package io.sadu.common

import io.sadu.common.module.Module
import io.sadu.common.tasks.TaskManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

interface SaduApplication : CoroutineScope, AutoCloseable {
    val applicationName: String
    val applicationVersion: String

    val taskManager: TaskManager<*>

    fun modules(): List<Module<SaduApplication>>

    val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Default + SupervisorJob())

    override val coroutineContext: CoroutineContext
        get() = scope.coroutineContext

    override fun close() {
        scope.cancel()
    }
}