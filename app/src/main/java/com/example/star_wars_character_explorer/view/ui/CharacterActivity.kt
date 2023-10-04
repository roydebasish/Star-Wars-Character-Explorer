package com.example.star_wars_character_explorer.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.star_wars_character_explorer.databinding.ActivityCharacterBinding
import com.example.star_wars_character_explorer.service.network.ApiInterface
import com.example.star_wars_character_explorer.service.network.RetrofitClient
import com.example.star_wars_character_explorer.service.repository.StarWarsRepository
import com.example.star_wars_character_explorer.view.adapter.CharacterAdapter
import com.example.star_wars_character_explorer.viewmodel.CharacterViewModel
import com.example.star_wars_character_explorer.viewmodel.StarViewModelFactory

class CharacterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCharacterBinding
    private lateinit var viewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter

    lateinit var apiInterface: ApiInterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)

        val starWarsRepository = StarWarsRepository(apiInterface)

        prepareRecyclerView()


//        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
//        viewModel.getCharecterList().observe(this, Observer {
//            characterAdapter.setMovieList(it)
//        })


//        apiInterface.getPeopleList().enqueue(
//            object : Callback<PeopleResponse> {
//                override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
//                    if (response.isSuccessful){
//                        Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
//                        characterAdapter.setMovieList(response.body()!!.results)
//                    }
//                    else{
//                        Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
//                    Toast.makeText(applicationContext, "Error "+t, Toast.LENGTH_SHORT).show()
//                }
//
//            },
//        )

        viewModel = ViewModelProvider(this, StarViewModelFactory(starWarsRepository))[CharacterViewModel::class.java]

        viewModel.charaterList.observe(this) {
            characterAdapter.setMovieList(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getAllMovies()

    }

    private fun prepareRecyclerView() {
        characterAdapter = CharacterAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = characterAdapter
        }
    }
}
