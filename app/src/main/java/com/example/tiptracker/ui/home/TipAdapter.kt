package com.example.tiptracker.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiptracker.data.Tip
import com.example.tiptracker.databinding.ItemTipBinding
import java.text.SimpleDateFormat
import java.util.*

class TipAdapter : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    private var items: List<Tip> = emptyList()

    fun submitList(newList: List<Tip>) {
        items = newList
        notifyDataSetChanged()
    }

    inner class TipViewHolder(val binding: ItemTipBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemTipBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = items[position]

        holder.binding.tvAmount.text = "${tip.amount} лв"

        val date = Date(tip.timestamp)
        val formatter = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
        holder.binding.tvDate.text = formatter.format(date)
    }

    override fun getItemCount() = items.size
}
