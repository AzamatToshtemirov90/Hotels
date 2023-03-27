package com.azamat.hotelapp.model.remote.response.detail

import com.google.gson.annotations.SerializedName

data class PropertyImage(
    val image: Image?,
    @SerializedName("__typename")
    val typename: String
)