package com.azamat.hotelapp.base

import com.azamat.hotelapp.model.remote.response.error.Status

data class BaseApiResult<out T> (val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): BaseApiResult<T> {
            return BaseApiResult(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): BaseApiResult<T> {
            return BaseApiResult(Status.ERROR, data, msg)
        }
    }
}