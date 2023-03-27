package com.azamat.hotelapp.model.remote.response.error

data class ErrorResponseBody(
    val status: String?,
    val code: String?,
    val message: String?
)