package com.azamat.hotelapp.model.repository

import com.azamat.hotelapp.base.BaseApiResult
import com.azamat.hotelapp.model.remote.request.HotelListRequest
import com.azamat.hotelapp.model.remote.response.detail.HotelDetailsResponse
import com.azamat.hotelapp.model.remote.response.search.HotelSearchResponse

interface RemoteRepository {

    suspend fun getHotels(location: String): BaseApiResult<HotelSearchResponse>

    suspend fun getHotelDetails(request: HotelListRequest): BaseApiResult<HotelDetailsResponse>

}