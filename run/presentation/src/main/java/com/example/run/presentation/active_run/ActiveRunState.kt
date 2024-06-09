package com.example.run.presentation.active_run

import com.example.core.domain.location.Location
import com.example.run.presentation.active_run.model.RunDataUi
import kotlin.time.Duration

data class ActiveRunState(
    val elapsedTime: Duration = Duration.ZERO,
    val runDataUi: RunDataUi = RunDataUi(),
    val distanceMeters: Int = 0,
    val shouldTrack: Boolean = false,
    val hasStartedRunning: Boolean = false,
    val currentLocation: Location? = null,
    val isRunFinished: Boolean = false,
    val isSavingRun: Boolean = false,
    val showLocationRationale: Boolean = false,
    val showNotificationRationale: Boolean = false
)