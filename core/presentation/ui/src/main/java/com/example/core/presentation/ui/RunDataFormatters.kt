package com.example.core.presentation.ui

import com.example.core.domain.util.toFeet
import com.example.core.domain.util.toKm
import com.example.core.domain.util.toMiles
import com.example.core.domain.util.toPacePerMile
import kotlin.math.pow
import kotlin.math.round
import kotlin.time.Duration

typealias DistanceMeters = Int
typealias DistanceKiloMeters = Double
typealias PacePerKilometer = Duration

fun Duration.formatted(): String {
    val totalSeconds = inWholeSeconds
    val hours = String.format("%02d", totalSeconds / (60 * 60))
    val minutes = String.format("%02d", (totalSeconds % 3600) / 60)
    val seconds = String.format("%02d", (totalSeconds % 60))

    return "$hours:$minutes:$seconds"
}

fun DistanceMeters.toFormattedDistance(distanceUnit: DistanceUnit): String {
    return when (distanceUnit) {
        DistanceUnit.MILES -> "${toMiles().roundToDecimals(2)} mi"
        DistanceUnit.KILOMETERS -> "${toKm().roundToDecimals(2)} km"
    }
}

fun PacePerKilometer.toFormattedPace(distanceUnit: DistanceUnit): String {
    val pacePerUnit = if (distanceUnit == DistanceUnit.MILES) toPacePerMile() else this
    val paceMinutes = pacePerUnit.inWholeMinutes
    val paceSeconds = String.format("%02d", pacePerUnit.inWholeSeconds % 60)
    return when (distanceUnit) {
        DistanceUnit.MILES -> "$paceMinutes:$paceSeconds / mi"
        DistanceUnit.KILOMETERS -> "$paceMinutes:$paceSeconds / km"
    }
}

fun DistanceKiloMeters.toFormattedSpeed(distanceUnit: DistanceUnit): String {
    return when (distanceUnit) {
        DistanceUnit.MILES -> "${toMiles().roundToDecimals(1)} mph"
        DistanceUnit.KILOMETERS -> "${roundToDecimals(1)} km/h"
    }
}

fun DistanceMeters.toFormattedElevation(distanceUnit: DistanceUnit): String {
    return when (distanceUnit) {
        DistanceUnit.MILES -> "${toFeet().roundToDecimals(0).toInt()} ft"
        DistanceUnit.KILOMETERS -> "$this m"
    }
}

private fun Double.roundToDecimals(decimalCount: Int): Double {
    val factor = 10f.pow(decimalCount)
    return round(this * factor) / factor
}