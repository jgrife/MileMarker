package com.example.run.presentation.run_overview.model

import com.example.core.domain.run.Run
import com.example.core.presentation.ui.formatted
import com.example.core.presentation.ui.toFormattedDistance
import com.example.core.presentation.ui.toFormattedSpeed
import com.example.core.presentation.ui.toFormattedElevation
import com.example.core.presentation.ui.toFormattedPace
import com.example.core.presentation.ui.DistanceUnit
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(distanceUnit: DistanceUnit): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceMeters.toFormattedDistance(distanceUnit),
        avgSpeed = avgSpeedKmh.toFormattedSpeed(distanceUnit),
        maxSpeed = maxSpeedKmh.toFormattedSpeed(distanceUnit),
        pace = pacePerKilometer.toFormattedPace(distanceUnit),
        totalElevation = totalElevationMeters.toFormattedElevation(distanceUnit),
        mapPictureUrl = mapPictureUrl
    )
}