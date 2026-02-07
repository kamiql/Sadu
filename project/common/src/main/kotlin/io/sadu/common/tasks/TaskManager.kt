package io.sadu.common.tasks

import kotlin.time.Duration

abstract class TaskManager<T: Task<*>> {
    private val tasks = mutableListOf<T>()

    abstract fun build(builder: TaskBuilder<T>): T

    fun sync(block: TaskBuilder<T>.() -> Unit) {
        return TaskBuilder(this).sync().block()
    }

    fun async(block: TaskBuilder<T>.() -> Unit) {
        return TaskBuilder(this).async().block()
    }

    class TaskBuilder<T : Task<*>>(val manager: TaskManager<T>) {
        internal var async: Boolean = true
        internal var delay: Duration = Duration.ZERO
        internal var repeat: Duration? = null
        internal var until: (() -> Boolean)? = null
        internal var block: ((T) -> Unit)? = null

        fun async(): TaskBuilder<T> {
            async = true
            return this
        }

        fun sync(): TaskBuilder<T> {
            async = false
            return this
        }

        fun delay(duration: Duration): TaskBuilder<T> {
            delay = duration
            return this
        }

        fun repeatEvery(duration: Duration): TaskBuilder<T> {
            repeat = duration
            return this
        }

        fun until(validate: () -> Boolean): TaskBuilder<T> {
            until = validate
            return this
        }

        fun run(block: (T) -> Unit): T {
            this.block = block

            manager.tasks.add(manager.build(this))

            return manager.build(this)
        }

        fun data(): TaskBuilderData<T> = TaskBuilderData(async, delay, repeat, until, block)

        data class TaskBuilderData<T: Task<*>>(
            val async: Boolean,
            val delay: Duration,
            val repeat: Duration?,
            val until: (() -> Boolean)?,
            val block: ((T) -> Unit)?
        )
    }
}