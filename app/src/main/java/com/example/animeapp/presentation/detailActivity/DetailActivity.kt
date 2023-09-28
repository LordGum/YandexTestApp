package com.example.animeapp.presentation.detailActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animeapp.R
import com.example.animeapp.data.network.pojo.Datum
import com.example.animeapp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val animeItem: Datum = intent.getSerializableExtra(EXTRA_ANIME_ITEM) as Datum

        Picasso.get().load(animeItem.attributes.coverImage.large).into(binding.coverImage)
        binding.description.text = animeItem.attributes.description
    }

    companion object {
        const val EXTRA_ANIME_ITEM = "extra_anime_item"

        fun newIntent(context: Context, item: Datum): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ANIME_ITEM, item)
            return intent
        }
    }

}