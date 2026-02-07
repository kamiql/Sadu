package io.sadu.paper.tasks

import io.sadu.common.tasks.Task
import org.bukkit.scheduler.BukkitTask

class BukkitTask : Task<BukkitTask>() {
    override fun cancel() = task.cancel()
    override fun isCancelled(): Boolean = task.isCancelled
}