package com.example.imagefilter.listeners

import java.io.File

interface SavedImageListener {
    fun onImageClicked(file: File)
}