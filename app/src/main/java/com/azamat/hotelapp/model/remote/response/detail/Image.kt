package com.azamat.hotelapp.model.remote.response.detail

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("__typename")
    val typename: String,
    val url: String?
)