package com.example.tiptracker.ui.summary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tiptracker.databinding.ItemDailySummaryBinding

class DailySummaryAdapter : RecyclerView.Adapter<DailySummaryAdapter.ViewHolder>() {

    private var items: List<DailySummary> = emptyList()

    fun submitList(list: List<DailySummary>) {
        items = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemDailySummaryBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDailySummaryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvDate.text = item.day
        holder.binding.tvSum.text = "%.2f лв".format(item.total)
    }

    override fun getItemCount() = items.size
}
