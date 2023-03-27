package com.azamat.hotelapp.model.repository

import com.azamat.hotelapp.base.BaseApiResult
import com.azamat.hotelapp.base.BaseRepository
import com.azamat.hotelapp.model.remote.api.ApiService
import com.azamat.hotelapp.model.remote.request.HotelListRequest
import com.azamat.hotelapp.model.remote.response.detail.HotelDetailsResponse
import com.azamat.hotelapp.model.remote.response.search.HotelSearchResponse

class RemoteRepositoryImpl(private val apiService: ApiService) : RemoteRepository,
    BaseRepository() {


    override suspend fun getHotels(location: String): BaseApiResult<HotelSearchResponse> {
        return safeApi {
            apiService.getHotels(location)
        }
    }

    override suspend fun getHotelDetails(request: HotelListRequest): BaseApiResult<HotelDetailsResponse> {
        return safeApi {
            apiService.getHotelDetails(request)
        }
    }


}