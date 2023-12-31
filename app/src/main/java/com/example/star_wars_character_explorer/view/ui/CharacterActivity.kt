package com.example.star_wars_character_explorer.view.ui

import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.star_wars_character_explorer.databinding.ActivityCharacterBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.view.adapter.LoaderAdapter
import com.example.star_wars_character_explorer.view.adapter.CharacterPagingAdapter
import com.example.star_wars_character_explorer.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding
    private lateinit var viewModel: CharacterViewModel
    private lateinit var pagingAdapter: CharacterPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        viewModel.list.observe(this) {
            pagingAdapter.submitData(lifecycle, it)
        }


    }


    private fun prepareRecyclerView() {
        pagingAdapter = CharacterPagingAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = pagingAdapter.withLoadStateHeaderAndFooter(
                header = LoaderAdapter(),
                footer = LoaderAdapter()
            )
        }

        pagingAdapter.setOnClickListener(onClicked)
    }



    private val onClicked = object : OnItemClickListener {

        override fun onItemClickedListener(position: Int) {

            val bundle = Bundle()
            bundle.putInt("position", position)

            val intent = Intent(applicationContext,CharacterDetailsActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }


    }

}
