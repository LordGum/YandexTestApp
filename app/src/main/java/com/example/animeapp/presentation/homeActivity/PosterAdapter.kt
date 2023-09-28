package com.example.animeapp.presentation.homeActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapp.R
import com.example.animeapp.data.network.pojo.Datum
import com.squareup.picasso.Picasso

class PosterAdapter: ListAdapter<Datum, PosterAdapter.PosterViewHolder>(AnimeItemDiffCallback()) {

    var onClickListener: ((Datum) -> Unit)? = null

    class PosterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.poster_image)
        val starButton: ImageView = itemView.findViewById(R.id.star_button)
    }

    override fun getItemViewType(position: Int): Int {
        val animeItem = getItem(position)
        return  if(position == 1) VIEW_TYPE_FIRST
                else if(animeItem.isWatched)  VIEW_TYPE_WATCHED
                else VIEW_TYPE_NOT_WATCHED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val bg: Int = when(viewType) {
            VIEW_TYPE_NOT_WATCHED -> R.layout.poster_item
            VIEW_TYPE_WATCHED -> R.layout.poster_item_watched
            VIEW_TYPE_FIRST -> R.layout.poster_item_first
            else -> {
                VIEW_TYPE_UNKNOWN
                throw(RuntimeException("Unknown viewType in adapter"))
            }
        }
        val view: View = LayoutInflater.from(parent.context).inflate(
            bg,
            parent,
            false
        )
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val animeItem = getItem(position)

        if(holder.itemViewType != VIEW_TYPE_FIRST) {
            Picasso.get().load(animeItem.attributes.posterImage.large).into(holder.poster)
            if (animeItem.isFavorite) holder.starButton.setBackgroundResource(R.drawable.ic_star_on)
            else holder.starButton.setBackgroundResource(R.drawable.ic_star_off)
        }

        holder.itemView.setOnClickListener {
            onClickListener?.invoke(animeItem)
        }

    }

    companion object {
        const val VIEW_TYPE_WATCHED = 1
        const val VIEW_TYPE_NOT_WATCHED = 0
        const val VIEW_TYPE_UNKNOWN = -1
        const val VIEW_TYPE_FIRST = 2

        const val MAX_POOL_SIZE = 20
    }
}

