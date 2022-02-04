package com.example.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.data.Notes
import com.example.notes.databinding.NotesItemsBinding

class NotesListAdapter(private val onNotesClicked: (Notes) -> Unit) :
    ListAdapter<Notes, NotesListAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            NotesItemsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onNotesClicked(current)
        }
        holder.bind(current)
    }

    class ItemViewHolder(private var binding:NotesItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Notes) {
            binding.title.text = item.title
            binding.datetime.text = item.content
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Notes>() {
            override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}