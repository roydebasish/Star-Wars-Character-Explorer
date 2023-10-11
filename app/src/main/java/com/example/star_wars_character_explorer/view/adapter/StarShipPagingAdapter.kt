package com.example.star_wars_character_explorer.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.star_wars_character_explorer.databinding.StarshipItemBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.service.model.StarShip

class StarShipPagingAdapter :
    PagingDataAdapter<StarShip, StarShipPagingAdapter.StarShipViewHolder>(COMPARATOR) {

    private lateinit var binding: StarshipItemBinding
    var itemlistener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarShipViewHolder {
        binding = StarshipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StarShipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StarShipViewHolder, position: Int) {

        val item = getItem(position)

        with(holder) {
            with(getItem(position)!!) {

                binding.tvName.text = name
                binding.tvModel.text = model
                binding.tvManufacturer.text = manufacturer

                binding.llContent.setOnClickListener {
                    itemlistener!!.onItemClickedListener(position+2)
                }

            }
        }


    }


    fun setOnClickListener(listener: OnItemClickListener) {
        itemlistener = listener
    }


    class StarShipViewHolder(val binding: StarshipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<StarShip>() {
            override fun areItemsTheSame(oldItem: StarShip, newItem: StarShip): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem.name == newItem.name;
            }

            override fun areContentsTheSame(oldItem: StarShip, newItem: StarShip): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem == newItem
            }
        }
    }

}