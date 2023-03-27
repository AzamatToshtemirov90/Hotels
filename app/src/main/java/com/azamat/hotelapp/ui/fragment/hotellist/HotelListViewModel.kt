package com.azamat.hotelapp.ui.fragment.hotellist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.azamat.hotelapp.base.BaseViewModel
import com.azamat.hotelapp.model.remote.response.error.Status
import com.azamat.hotelapp.model.remote.request.*
import com.azamat.hotelapp.model.remote.response.detail.HotelDetailsResponse
import com.azamat.hotelapp.model.remote.response.search.HotelSearchResponse
import com.azamat.hotelapp.model.repository.RemoteRepository
import kotlinx.coroutines.*

class HotelListViewModel (
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteRepository: RemoteRepository,
) : BaseViewModel() {

    private val TAG = HotelListViewModel::class.java.simpleName

    private var _hotelList = MutableLiveData<HotelSearchResponse?>()
    private val hotelList : LiveData<HotelSearchResponse?> = _hotelList

    private var _hotelDetails = MutableLiveData<HotelDetailsResponse?>()
    val hotelDetails: LiveData<HotelDetailsResponse?> = _hotelDetails


    fun getHotelList(location: String): HotelSearchResponse? {
        viewModelScope.launch(ioDispatcher) {
            remoteRepository.getHotels(location).let { baseApiResult ->
                when (baseApiResult.status) {
                    Status.SUCCESS -> {
                        baseApiResult.data?.let { it ->
                            _hotelList.postValue(it)
                        }
                    }
                    Status.ERROR -> {
                        _error.postValue(baseApiResult.message)
                        Log.d(TAG,baseApiResult.message.toString())
                    }
                }

            }
        }
        return hotelList.value
    }

    fun getHotelDetails(regionId: String) {
        viewModelScope.launch(ioDispatcher) {
            val request = initRequest(regionId)
            remoteRepository.getHotelDetails(request).let { baseApiResult->
                when (baseApiResult.status) {
                    Status.SUCCESS -> {
                        baseApiResult.data?.let { it->
                            _hotelDetails.postValue(it)
                        }
                    }
                    Status.ERROR -> {
                        //_error.postValue(baseApiResult.message)
                        _error.postValue(baseApiResult.message)
                        Log.d(TAG,baseApiResult.message.toString())
                    }
                }
            }
        }

    }

    private fun initRequest(regionId: String): HotelListRequest{
        val room = Room(2, listOf(Children(5), Children(7)))
        return HotelListRequest(
            CheckInDate(10, 10, 2022),
            CheckOutDate(15, 10, 2022),
            "USD",
            Destination(regionId),
            1,
            "en_US",
            200,
            0,
            listOf(room),
            300000001,
            "PRICE_LOW_TO_HIGH"
        )
    }

}