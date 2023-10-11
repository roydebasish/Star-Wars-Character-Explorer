package com.example.star_wars_character_explorer.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.star_wars_character_explorer.databinding.ActivityStarshipDetailsBinding
import com.example.star_wars_character_explorer.viewmodel.StarShipViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarShipDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityStarshipDetailsBinding
    private lateinit var viewModel: StarShipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarshipDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var position = -1

        if (bundle != null) position = bundle.getInt("position")


        viewModel = ViewModelProvider(this)[StarShipViewModel::class.java]

        viewModel.getStarShip(position).observe(this) {

            it?.let{
                binding.tvName.text = it.name
                binding.tvModel.text = it.model
                binding.tvStarshipClass.text = it.starship_class
                binding.tvManufacturer.text = it.manufacturer
                binding.tvCostCredits.text = it.cost_in_credits
                binding.tvCrew.text = it.crew
                binding.tvCargoCapacity.text = it.cargo_capacity
                binding.tvPassengers.text = it.passengers
            }
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })


    }
}