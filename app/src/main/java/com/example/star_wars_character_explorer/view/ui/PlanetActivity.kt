package com.example.star_wars_character_explorer.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.star_wars_character_explorer.databinding.ActivityPlanetBinding
import com.example.star_wars_character_explorer.listener.OnItemClickListener
import com.example.star_wars_character_explorer.view.adapter.LoaderAdapter
import com.example.star_wars_character_explorer.view.adapter.PlanetPagingAdapter
import com.example.star_wars_character_explorer.viewmodel.PlanetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlanetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetBinding
    private lateinit var viewModel: PlanetViewModel
    private lateinit var pagingAdapter: PlanetPagingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        viewModel = ViewModelProvider(this)[PlanetViewModel::class.java]

        viewModel.list.observe(this) {
            pagingAdapter.submitData(lifecycle, it)
        }


    }


    private fun prepareRecyclerView() {
        pagingAdapter = PlanetPagingAdapter()
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

            val intent = Intent(applicationContext,PlanetDetailsActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }


    }

}