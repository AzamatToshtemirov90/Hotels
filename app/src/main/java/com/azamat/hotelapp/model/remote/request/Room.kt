package com.azamat.hotelapp.model.remote.request

data class Room(
    val adults: Int,
    val children: List<Children>
)