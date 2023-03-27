package com.azamat.hotelapp.ui.fragment.details

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.azamat.hotelapp.R
import com.azamat.hotelapp.base.BaseFragment
import com.azamat.hotelapp.databinding.FragmentHotelDetailsBinding
import com.squareup.picasso.Picasso


class HotelDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentHotelDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDidLoad(
            imageUrl = arguments?.getString("imageUrl", "") ?: "",
            title = arguments?.getString("title", "") ?: "",
            price = arguments?.getString("price", "") ?: "",
            deal = arguments?.getString("deal", "") ?: ""
        )
    }

    private fun viewDidLoad(imageUrl: String, title: String, price: String, deal: String) {
        Picasso.get().load(imageUrl).into(binding.imgHotel)
        binding.tvDealDesc.text = deal
        binding.tvTitle.text = title
        binding.tvPrice.text = price
    }

    override fun onBackPressed() {
        super.onBackPressed()
        popTo(R.id.hotelListFragment)
    }


}