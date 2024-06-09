package com.example.run.presentation.active_run.model

import com.example.core.presentation.ui.DistanceUnit
import com.example.core.presentation.ui.toFormattedDistance
import com.example.core.presentation.ui.toFormattedPace
import com.example.run.domain.RunData

fun RunData.toRunDataUi(distanceUnit: DistanceUnit): RunDataUi {
    return RunDataUi(
        distance = distanceMeters.toFormattedDistance(distanceUnit),
        pace = pacePerKilometer.toFormattedPace(distanceUnit),
        locations = locations
    )
}