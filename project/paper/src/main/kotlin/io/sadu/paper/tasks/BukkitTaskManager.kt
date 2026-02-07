package io.sadu.paper.tasks

import io.sadu.common.tasks.TaskManager
import io.sadu.common.toBukkitTicks
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BukkitTaskManager(private val plugin: JavaPlugin) : TaskManager<BukkitTask>() {
    override fun build(builder: TaskBuilder<BukkitTask>): BukkitTask {
        val process = BukkitTask()
        val (async, delay, repeat, until, block) = builder.data()

        val scheduler = Bukkit.getScheduler()
        val delayTicks = delay.toBukkitTicks()
        val repeatTicks = repeat?.toBukkitTicks()

        val runnable: () -> Unit = {
            if (until?.invoke() == true) {
                process.cancel()
            } else {
                block?.invoke(process)
            }
        }

        val bukkitTask = when (repeatTicks) {
            null -> if (async) scheduler.runTaskLaterAsynchronously(plugin, runnable, delayTicks) else scheduler.runTaskLater(plugin, runnable, delayTicks)
            else -> if (async) scheduler.runTaskTimerAsynchronously(plugin, runnable, delayTicks, repeatTicks) else scheduler.runTaskTimer(plugin, runnable, delayTicks, repeatTicks)
        }

        process.task = bukkitTask
        return process
    }
}
