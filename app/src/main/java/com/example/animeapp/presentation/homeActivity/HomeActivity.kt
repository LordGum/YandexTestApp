package com.example.animeapp.presentation.homeActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.animeapp.R
import com.example.animeapp.databinding.ActivityHomeBinding
import com.example.animeapp.presentation.detailActivity.DetailActivity


private lateinit var binding: ActivityHomeBinding
private lateinit var adapter: PosterAdapter
private lateinit var viewModel: HomeViewModel

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setViewModel()
        typeListeners()
        setAdapter()
        setItemListener()
    }
    private fun typeListeners() {
        binding.adventure.setOnClickListener{
            binding.comedy.setBackgroundResource(R.drawable.style_type)
            binding.adventure.setBackgroundResource(R.drawable.style_type_selected)
            binding.fantasy.setBackgroundResource(R.drawable.style_type)
            viewModel.loadAdventure()
        }
        binding.fantasy.setOnClickListener{
            binding.adventure.setBackgroundResource(R.drawable.style_type)
            binding.fantasy.setBackgroundResource(R.drawable.style_type_selected)
            binding.comedy.setBackgroundResource(R.drawable.style_type)
            viewModel.loadFantasy()
        }
        binding.comedy.setOnClickListener{
            binding.adventure.setBackgroundResource(R.drawable.style_type)
            binding.fantasy.setBackgroundResource(R.drawable.style_type)
            binding.comedy.setBackgroundResource(R.drawable.style_type_selected)
            viewModel.loadComedy()
        }
    }

    private fun setAdapter() {
        binding.recycler.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )
        adapter = PosterAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.recycledViewPool.setMaxRecycledViews(
            PosterAdapter.VIEW_TYPE_NOT_WATCHED,
            PosterAdapter.MAX_POOL_SIZE
        )
        binding.recycler.recycledViewPool.setMaxRecycledViews(
            PosterAdapter.VIEW_TYPE_WATCHED,
            PosterAdapter.MAX_POOL_SIZE
        )
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.loadAdventure()
        viewModel.animeResponse.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setItemListener() {
        adapter.onClickListener = {
            val intent = DetailActivity.newIntent(this@HomeActivity, it)
            startActivity(intent)
        }
    }

}