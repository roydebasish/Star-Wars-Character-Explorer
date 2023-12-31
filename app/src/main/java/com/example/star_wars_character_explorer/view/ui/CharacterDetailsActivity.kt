package com.example.star_wars_character_explorer.view.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.star_wars_character_explorer.databinding.ActivityCharacterDetailsBinding
import com.example.star_wars_character_explorer.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterDetailsBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        var position = -1

        if (bundle != null) position = bundle.getInt("position")


        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        viewModel.getCharacter(position).observe(this) {

            it?.let{
                binding.tvName.text = it.name
                binding.tvBirthYear.text = it.birth_year
                binding.tvHeight.text = it.height
                binding.tvEyeColor.text = it.eye_color
                binding.tvSkinColor.text = it.skin_color
                binding.tvHairColor.text = it.hair_color
                binding.tvMass.text = it.mass
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