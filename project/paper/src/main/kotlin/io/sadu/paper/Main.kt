package io.sadu.paper

import io.sadu.common.SaduApplication
import io.sadu.common.module.Module
import io.sadu.paper.tasks.BukkitTaskManager
import io.sadu.common.tasks.TaskManager
import kotlinx.coroutines.launch
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(), SaduApplication {
    override val applicationName: String = this.pluginMeta.name
    override val applicationVersion: String = this.pluginMeta.version

    override val taskManager: TaskManager<*> = BukkitTaskManager(this)

    override fun modules(): List<Module<SaduApplication>> = listOf(

    )

    override fun onLoad() {
        launch {

        }
    }

    override fun onEnable() {
        launch {

        }
    }

    override fun onDisable() {
        launch {
            // ALWAYS CALL THIS LAST
            close()
        }
    }
}