package com.tah.housewarming.data

import java.lang.Exception

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    val status: Status,
    val msg: Exception? = null) {

    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        val EMPTY = NetworkState(Status.EMPTY)
        fun error(exception: Exception?) = NetworkState(Status.FAILED, exception)
    }

}

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED,
    EMPTY
}