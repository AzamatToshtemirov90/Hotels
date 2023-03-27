package com.azamat.hotelapp.ui.fragment.hotellist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.azamat.hotelapp.R
import com.azamat.hotelapp.base.BaseFragment
import com.azamat.hotelapp.databinding.FragmentListHotelsBinding
import com.azamat.hotelapp.model.remote.response.search.HotelSearchResponse
import org.koin.androidx.viewmodel.ext.android.viewModel


class HotelListFragment : BaseFragment() {
    private lateinit var binding: FragmentListHotelsBinding
    private val viewModel: HotelListViewModel by viewModel()
    lateinit var adapter: HotelListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListHotelsBinding.inflate(inflater, container, false)
        binding.ivSearch.setOnClickListener {
            getHotelLocation()
        }
        binding.etSearch.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                getHotelLocation()
            }
            return@setOnEditorActionListener true
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewDidLoad()
    }

    private fun viewDidLoad() {
        initRecyclerView()
        getHotelLocation()
        observeData()
    }

    private fun observeData() {
        viewModel.error.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            binding.tvErrorNotification.visibility = View.VISIBLE

            it?.let {
                if (it.contains("2147483647")) {
                    Toast.makeText(
                        requireContext(),
                        "NO INTERNET CONNECTION\nConnect with Internet to get the updated data!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    binding.tvErrorNotification.text = it

                }
            }
        }
    }

    fun getHotelLocation() {
        val searchText = binding.etSearch.text.toString()
        if (searchText.isEmpty()) {
            Toast.makeText(requireContext(), "Please enter a valid location", Toast.LENGTH_LONG)
                .show()
        } else {
            fetchHotelList(searchText)
        }
    }

    private fun initRecyclerView() {
        adapter = HotelListAdapter(HotelListAdapter.OnItemClickListener { property ->
            val bundle = bundleOf(
                "imageUrl" to property.propertyImage?.image?.url,
                "title" to property.name,
                "price" to property.price?.options?.get(0)?.formattedDisplayPrice,
                "deal" to property.priceMetadata?.rateDiscount?.description
            )
            navigate(R.id.hotelDetailsFragment, bundle)
        })
        binding.rvHotels.adapter = adapter
        binding.rvHotels.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun fetchHotelList(query: String) {
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.getHotelList(query)

        viewModel.getHotelDetails(getRegionId(response))
        viewModel.hotelDetails.observe(viewLifecycleOwner) { it ->
            if (it != null) {
                adapter.items = it.data.propertySearch.properties
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE

            }
        }

    }

    private fun getRegionId(response: HotelSearchResponse?): String {
        try {
            for (regionId in response!!.hotelList) {
                if (regionId.type == "gaiaRegionResult")
                    return regionId.gaiaId
            }
        } catch (e: java.lang.Exception) {
            binding.tvErrorNotification.text = "RegionNotFoundException"
        }
        return ""
    }

}