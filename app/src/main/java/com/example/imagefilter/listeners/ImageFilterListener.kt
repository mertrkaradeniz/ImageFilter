package com.example.imagefilter.listeners

import com.example.imagefilter.data.model.ImageFilter

interface ImageFilterListener {
    fun onFilterSelected(imageFilter: ImageFilter)
}