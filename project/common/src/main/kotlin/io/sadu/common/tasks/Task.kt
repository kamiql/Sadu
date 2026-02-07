package io.sadu.common.tasks

abstract class Task<T: Any> {
    lateinit var task: T

    abstract fun cancel()
    abstract fun isCancelled(): Boolean
}