package com.example.star_wars_character_explorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.star_wars_character_explorer.databinding.CharacterItemBinding
import com.example.star_wars_character_explorer.service.model.People

class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.AppsViewHolder>() {

    var itemlistener: AdapterView.OnItemClickListener? = null

    private lateinit var binding: CharacterItemBinding

    private var charaterList = ArrayList<People>()

    fun setMovieList(charaterList : List<People>){
        this.charaterList = charaterList as ArrayList<People>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return charaterList.size
    }



    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {

        with(holder) {
            with(charaterList[position]) {

                binding.tvName.text = name
                binding.tvBirthYear.text = birth_year

            }
        }


    }

    class AppsViewHolder(val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}