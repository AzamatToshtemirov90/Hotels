package com.azamat.hotelapp.model.remote.request

data class HotelListRequest(
    val checkInDate: CheckInDate,
    val checkOutDate: CheckOutDate,
    val currency: String,
    val destination: Destination,
    val eapid: Int,
    val locale: String,
    val resultsSize: Int,
    val resultsStartingIndex: Int,
    val rooms: List<Room>,
    val siteId: Int,
    val sort: String
)