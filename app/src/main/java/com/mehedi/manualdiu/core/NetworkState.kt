package com.mehedi.manualdiu.core

sealed class  NetworkState<T>(
    var data: T? = null,
    var message: String? = null
) {
    class Loading<T> : NetworkState<T>()
    class Success<T>(data: T) : NetworkState<T>(data)
    class Error<T>(msg: String) : NetworkState<T>(message = msg)
}
