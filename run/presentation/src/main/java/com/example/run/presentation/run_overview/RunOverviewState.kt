package com.example.run.presentation.run_overview

import com.example.core.domain.run.Run
import com.example.core.presentation.ui.DistanceUnit
import com.example.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runsUi: List<RunUi> = emptyList(),
    val runs: List<Run> = emptyList(),
    val currentDistanceUnit: DistanceUnit = DistanceUnit.MILES
)
