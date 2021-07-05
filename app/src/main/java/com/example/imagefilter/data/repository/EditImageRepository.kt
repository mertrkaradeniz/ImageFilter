package com.example.imagefilter.data.repository

import android.graphics.Bitmap
import android.net.Uri
import com.example.imagefilter.data.model.ImageFilter

interface EditImageRepository {
    suspend fun prepareImagePreview(imageUri: Uri): Bitmap?
    suspend fun getImageFilters(image: Bitmap): List<ImageFilter>
    suspend fun saveFilteredImage(filteredBitmap: Bitmap): Uri?
}