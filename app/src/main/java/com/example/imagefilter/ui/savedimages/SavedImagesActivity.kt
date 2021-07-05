package com.example.imagefilter.ui.savedimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.FileProvider
import com.example.imagefilter.R
import com.example.imagefilter.adapters.SavedImagesAdapter
import com.example.imagefilter.databinding.ActivitySavedImagesBinding
import com.example.imagefilter.listeners.SavedImageListener
import com.example.imagefilter.ui.editimage.EditImageActivity
import com.example.imagefilter.ui.filteredimage.FilteredImageActivity
import com.example.imagefilter.utils.displayToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class SavedImagesActivity : AppCompatActivity(), SavedImageListener {

    private lateinit var binding: ActivitySavedImagesBinding
    private val viewModel: SavedImagesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupObserver()
        setListeners()
        viewModel.loadSavedImages()
    }

    private fun setupObserver() {
        viewModel.savedImagesUiState.observe(this, {
            val savedImagesDataState = it ?: return@observe
            binding.pbSavedImages.visibility =
                if (savedImagesDataState.isLoading) View.VISIBLE else View.GONE
            savedImagesDataState.savedImages?.let { savedImages ->
                SavedImagesAdapter(savedImages, this).also { adapter ->
                    with(binding.rvSavedImages) {
                        this.adapter = adapter
                        visibility = View.VISIBLE
                    }
                }
            } ?: run {
                savedImagesDataState.error?.let { error ->
                    displayToast(error)
                }
            }
        })
    }

    private fun setListeners() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onImageClicked(file: File) {
        val fileUri = FileProvider.getUriForFile(
            applicationContext,
            "${packageName}.provider",
            file
        )
        Intent(
            applicationContext,
            FilteredImageActivity::class.java
        ).also { filteredImageIntent ->
            filteredImageIntent.putExtra(EditImageActivity.KEY_FILTERED_IMAGE_URI, fileUri)
            startActivity(filteredImageIntent)
        }
    }
}