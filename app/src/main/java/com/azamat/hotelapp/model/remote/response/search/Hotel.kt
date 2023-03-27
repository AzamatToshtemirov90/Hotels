package com.azamat.hotelapp.model.remote.response.search

import com.google.gson.annotations.SerializedName

data class Hotel(
    val gaiaId: String,
    @SerializedName("@type")
    val type: String
)