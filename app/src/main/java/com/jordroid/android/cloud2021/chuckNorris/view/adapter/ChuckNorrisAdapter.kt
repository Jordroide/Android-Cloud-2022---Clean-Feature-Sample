package com.jordroid.android.cloud2021.chuckNorris.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jordroid.android.cloud2021.chuckNorris.view.model.ChuckNorrisUi
import com.jordroid.android.cloud2021.databinding.ItemChuckNorrisBinding

val diffUtils = object : DiffUtil.ItemCallback<ChuckNorrisUi>() {
    override fun areItemsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ChuckNorrisUi, newItem: ChuckNorrisUi): Boolean {
        return oldItem == newItem
    }
}

class ChuckNorrisAdapter : ListAdapter<ChuckNorrisUi, ChuckNorrisQuoteViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckNorrisQuoteViewHolder {
        return ChuckNorrisQuoteViewHolder(
            ItemChuckNorrisBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChuckNorrisQuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ChuckNorrisQuoteViewHolder(
    private val binding: ItemChuckNorrisBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: ChuckNorrisUi

    fun bind(chuckNorrisUi: ChuckNorrisUi) {
        ui = chuckNorrisUi
        Glide.with(itemView.context)
            .load(chuckNorrisUi.url)
            .into(binding.itemChuckNorrisIcon)

        binding.itemChuckNorrisQuote.text = chuckNorrisUi.title
    }
}
