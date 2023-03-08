package com.dicoding.androidexamdicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.androidexamdicoding.databinding.ItemRowExoBinding

class ExoAdapter(private val listExo: ArrayList<Exo>) : RecyclerView.Adapter<ExoAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    interface OnItemClickCallback {
        fun onItemClicked(data: Exo)
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(var binding: ItemRowExoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowExoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listExo.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, desc, photo) = listExo[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDesc.text = desc
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listExo[holder.adapterPosition])
        }
    }
}