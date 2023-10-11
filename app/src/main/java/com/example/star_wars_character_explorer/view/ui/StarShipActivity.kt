package com.example.star_wars_character_explorer.view.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.star_wars_character_explorer.databinding.ActivityStarShipBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.view.adapter.LoaderAdapter
import com.example.star_wars_character_explorer.view.adapter.StarShipPagingAdapter
import com.example.star_wars_character_explorer.viewmodel.StarShipViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarShipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStarShipBinding
    private lateinit var viewModel: StarShipViewModel
    private lateinit var pagingAdapter: StarShipPagingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarShipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[StarShipViewModel::class.java]

        viewModel.list.observe(this) {
            pagingAdapter.submitData(lifecycle, it)
        }


    }


    private fun prepareRecyclerView() {
        pagingAdapter = StarShipPagingAdapter()
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

            val intent = Intent(applicationContext,StarShipDetailsActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }

}