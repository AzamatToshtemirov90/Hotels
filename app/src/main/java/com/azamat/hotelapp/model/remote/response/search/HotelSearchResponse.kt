package com.azamat.hotelapp.model.remote.response.search

import com.google.gson.annotations.SerializedName

data class HotelSearchResponse(
    val q: String,
    val rc: String,
    val rid: String,
    @SerializedName("sr")
    val hotelList: List<Hotel>
)