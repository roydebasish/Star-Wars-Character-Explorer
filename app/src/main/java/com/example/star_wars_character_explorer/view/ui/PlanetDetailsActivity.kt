package com.example.star_wars_character_explorer.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.star_wars_character_explorer.databinding.ActivityPlanetDetailsBinding
import com.example.star_wars_character_explorer.viewmodel.PlanetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPlanetDetailsBinding
    private lateinit var viewModel: PlanetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var position = -1

        if (bundle != null) position = bundle.getInt("position")



        viewModel = ViewModelProvider(this)[PlanetViewModel::class.java]

        viewModel.getPlanet(position).observe(this) {

            it?.let{
                binding.tvName.text = it.name
                binding.tvClimate.text = it.climate
                binding.tvdiameter.text = it.diameter
                binding.tvGravity.text = it.gravity
                binding.tvTerrain.text = it.terrain
                binding.tvPopulation.text = it.population
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