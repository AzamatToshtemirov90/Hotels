package com.azamat.hotelapp.ui.fragment.hotellist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamat.hotelapp.databinding.ItemListHotelsBinding
import com.azamat.hotelapp.model.remote.response.detail.Property
import com.squareup.picasso.Picasso

class HotelListAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HotelListAdapter.ViewHolder>() {

    var items = listOf<Property>()

    lateinit var binding: ItemListHotelsBinding

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListHotelsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel = items[position]
        binding.tvName.text = hotel.name
        Picasso.get().load(hotel.propertyImage?.image?.url).into(binding.imgItem)
        binding.tvDealDesc.text = hotel.priceMetadata?.rateDiscount?.description ?: ""
        if (binding.tvDealDesc.text.isEmpty())
            binding.imgDeal.visibility = View.GONE
        else
            binding.imgDeal.visibility = View.VISIBLE
        holder.itemView.setOnClickListener {
            listener.onItemClick(hotel)
        }
    }

    class OnItemClickListener(val listener: (property: Property) -> Unit) {
        fun onItemClick(property: Property) = listener(property)
    }

    class ViewHolder(binding: ItemListHotelsBinding) :
        RecyclerView.ViewHolder(binding.root)
}