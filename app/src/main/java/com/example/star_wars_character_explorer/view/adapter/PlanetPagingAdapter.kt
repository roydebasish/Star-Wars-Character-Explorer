package com.example.star_wars_character_explorer.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.star_wars_character_explorer.databinding.PlanetItemBinding
import com.example.star_wars_character_explorer.databinding.StarshipItemBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.service.model.Planet

class PlanetPagingAdapter :
    PagingDataAdapter<Planet, PlanetPagingAdapter.PlanetViewHolder>(COMPARATOR) {

    private lateinit var binding: PlanetItemBinding
    var itemlistener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        binding = PlanetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {

        val item = getItem(position)

        with(holder) {
            with(getItem(position)!!) {

                binding.tvName.text = name
                binding.tvPopulation.text = population
                binding.tvClimate.text = climate
                binding.tvTerrain.text = terrain

                binding.llContent.setOnClickListener {
                    itemlistener!!.onItemClickedListener(position+1)
                }

            }
        }


    }


    fun setOnClickListener(listener: OnItemClickListener) {
        itemlistener = listener
    }


    class PlanetViewHolder(val binding: PlanetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Planet>() {
            override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem.name == newItem.name;
            }

            override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem == newItem
            }
        }
    }

}