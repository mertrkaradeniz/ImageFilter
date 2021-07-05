package com.example.imagefilter.data.repository

import android.graphics.Bitmap
import android.net.Uri

interface EditImageRepository {
    suspend fun prepareImagePreview(imageUri: Uri): Bitmap?
}