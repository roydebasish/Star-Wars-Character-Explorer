package com.example.star_wars_character_explorer.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.star_wars_character_explorer.databinding.CharacterItemBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.service.model.People

class CharacterPagingAdapter :
    PagingDataAdapter<People, CharacterPagingAdapter.CharacterViewHolder>(COMPARATOR) {

    private lateinit var binding: CharacterItemBinding
    var itemlistener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

//        val item = getItem(position)

        with(holder) {
            with(getItem(position)!!) {

                binding.tvName.text = name
                binding.tvBirthYear.text = birth_year

                binding.llContent.setOnClickListener {
                    itemlistener!!.onItemClickedListener(position+1)
                }

            }
        }


    }

    fun setOnClickListener(listener: OnItemClickListener) {
        itemlistener = listener
    }

    class CharacterViewHolder(val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<People>() {
            override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem.name == newItem.name;
            }

            override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
                Log.d("TAG", Thread.currentThread().name)
                return oldItem == newItem
            }
        }
    }

}