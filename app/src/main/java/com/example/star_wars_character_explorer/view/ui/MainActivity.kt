package com.example.star_wars_character_explorer.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.star_wars_character_explorer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNavigateCharacters.setOnClickListener {
            val charactersIntent = Intent(this,CharacterActivity::class.java)
            startActivity(charactersIntent)
        }

        binding.btnNavigateStarships.setOnClickListener {
            val charactersIntent = Intent(this,StarShipActivity::class.java)
            startActivity(charactersIntent)
        }

        binding.btnNavigatePlanet.setOnClickListener {
            val charactersIntent = Intent(this,PlanetActivity::class.java)
            startActivity(charactersIntent)
        }

    }
}