package com.example.animeapp.presentation.homeActivity

import androidx.recyclerview.widget.DiffUtil
import com.example.animeapp.data.network.pojo.Datum

class AnimeItemDiffCallback: DiffUtil.ItemCallback<Datum>() {
    override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem == newItem
    }
}