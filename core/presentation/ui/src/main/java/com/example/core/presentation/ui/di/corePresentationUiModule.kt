package com.example.core.presentation.ui.di

import com.example.core.presentation.ui.DistanceUnitStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val corePresentationUiModule = module {
    singleOf(::DistanceUnitStorage)
}