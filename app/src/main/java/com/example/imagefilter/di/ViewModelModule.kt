package com.example.imagefilter.di

import com.example.imagefilter.ui.editimage.EditImageViewModel
import com.example.imagefilter.ui.savedimages.SavedImagesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { EditImageViewModel(editImageRepository = get()) }
    viewModel { SavedImagesViewModel(savedImagesRepository = get()) }
}