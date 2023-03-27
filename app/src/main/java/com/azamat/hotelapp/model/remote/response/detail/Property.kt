package com.azamat.hotelapp.model.remote.response.detail

import com.google.gson.annotations.SerializedName

data class Property(
    val id: String,
    val name: String?,
    val propertyImage: PropertyImage?,
    val price: Price?,
    val priceMetadata: PriceMetadata?,
    @SerializedName("__typename")
    val typename: String
)