package com.example.core.domain.util

import kotlin.time.Duration

typealias DistanceMeters = Int
typealias DistanceKiloMeters = Double
typealias PacePerKilometer = Duration

fun DistanceMeters.toKm(): Double = this / 1000.0

fun DistanceMeters.toFeet(): Double = this * 3.28084

fun DistanceMeters.toMiles(): Double = this * 0.000621371

fun DistanceKiloMeters.toMiles():  Double = this * 0.621371

fun PacePerKilometer.toPacePerMile(): Duration {
    val kilometersPerMile = 1 / 0.621371
    return this * kilometersPerMile
}