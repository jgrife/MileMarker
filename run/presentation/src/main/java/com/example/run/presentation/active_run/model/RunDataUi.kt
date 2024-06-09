package com.example.run.presentation.active_run.model

import com.example.core.domain.location.LocationTimestamp

data class RunDataUi(
    val distance: String = "",
    val pace: String = "",
    val locations: List<List<LocationTimestamp>> = emptyList()
)