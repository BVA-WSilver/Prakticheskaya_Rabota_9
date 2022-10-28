package com.gwsilver.prakticheskaya_rabota_9

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gwsilver.prakticheskaya_rabota_9.databinding.ItemBinding


class StartAdapter: RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

    var listStart = emptyList<ListItem>()


    class StartViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = ItemBinding.bind(item)
        fun bind(valutaItem: ListItem) = with(binding){

            tvValuta.text = valutaItem.nameValuta
            tvKurs.text = valutaItem.curs.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.bind(listStart[position])
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ListItem>) {

        listStart = list

        notifyDataSetChanged()
    }
}