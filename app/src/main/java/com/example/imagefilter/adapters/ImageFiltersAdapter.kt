package com.example.imagefilter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagefilter.data.model.ImageFilter
import com.example.imagefilter.databinding.ItemContainerFilterBinding

class ImageFiltersAdapter(private val imageFilters: List<ImageFilter>) :
    RecyclerView.Adapter<ImageFiltersAdapter.ImageFilterViewHolder>() {

    inner class ImageFilterViewHolder(val binding: ItemContainerFilterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageFilterViewHolder {
        val binding = ItemContainerFilterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageFilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageFilterViewHolder, position: Int) {
        with(holder) {
            with(imageFilters[position]) {
                binding.imageFilterPreview.setImageBitmap(filterPreview)
                binding.tvFilterName.text = name
            }
        }
    }

    override fun getItemCount() = imageFilters.size
}