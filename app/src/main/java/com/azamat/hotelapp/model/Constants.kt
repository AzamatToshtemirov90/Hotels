package com.azamat.hotelapp.model

object Constants {
    const val OkHttp_TIMEOUT = 5L // connection timeout

    object Headers{
        const val SEARCH_ATTRIBUTES = "locations/v3/search"
        const val DETAIL_ATTRIBUTES = "properties/v2/list"
        const val CONTENT_TYPE = "application/json"

    }
}