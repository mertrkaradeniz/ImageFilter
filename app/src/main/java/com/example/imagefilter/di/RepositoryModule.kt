package com.example.imagefilter.di

import com.example.imagefilter.data.repository.EditImageRepository
import com.example.imagefilter.data.repository.EditImageRepositoryImpl
import com.example.imagefilter.data.repository.SavedImagesRepository
import com.example.imagefilter.data.repository.SavedImagesRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<EditImageRepository> { EditImageRepositoryImpl(androidContext()) }
    factory<SavedImagesRepository> { SavedImagesRepositoryImpl(androidContext()) }

}