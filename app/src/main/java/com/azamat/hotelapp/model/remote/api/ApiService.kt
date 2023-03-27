package com.azamat.hotelapp.model.remote.api

import com.azamat.hotelapp.model.Constants
import com.azamat.hotelapp.model.remote.request.HotelListRequest
import com.azamat.hotelapp.model.remote.response.detail.HotelDetailsResponse
import com.azamat.hotelapp.model.remote.response.search.HotelSearchResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.Headers.SEARCH_ATTRIBUTES)
    suspend fun getHotels(
        @Query("q") location: String,
        @Query("locale") locale: String = "en_US",
        @Query("langid") langId: String = "1033",
        @Query("siteid") siteId: String = "300000001"
    ): HotelSearchResponse

    @POST(Constants.Headers.DETAIL_ATTRIBUTES)
    suspend fun getHotelDetails(@Body request: HotelListRequest): HotelDetailsResponse
}