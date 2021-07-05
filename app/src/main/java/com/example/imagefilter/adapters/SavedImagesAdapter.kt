package com.example.imagefilter.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagefilter.databinding.ItemContainerSavedImageBinding
import com.example.imagefilter.listeners.SavedImageListener
import java.io.File

class SavedImagesAdapter(
    private val savedImages: List<Pair<File, Bitmap>>,
    private val savedImageListener: SavedImageListener
) : RecyclerView.Adapter<SavedImagesAdapter.SavedImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedImagesViewHolder {
        val binding = ItemContainerSavedImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SavedImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedImagesViewHolder, position: Int) {
        with(holder) {
            with(savedImages[position]) {
                binding.imgSaved.setImageBitmap(second)
                binding.imgSaved.setOnClickListener {
                    savedImageListener.onImageClicked(first)
                }
            }
        }
    }

    override fun getItemCount() = savedImages.size

    inner class SavedImagesViewHolder(val binding: ItemContainerSavedImageBinding) :
        RecyclerView.ViewHolder(binding.root)
}