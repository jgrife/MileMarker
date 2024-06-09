package com.example.run.presentation.run_overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.auth.SessionStorage
import com.example.core.domain.run.RunRepository
import com.example.core.domain.run.SyncRunScheduler
import com.example.core.presentation.ui.DistanceUnit
import com.example.core.presentation.ui.DistanceUnitStorage
import com.example.run.presentation.run_overview.model.toRunUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.minutes

class RunOverviewViewModel(
    private val runRepository: RunRepository,
    private val syncRunScheduler: SyncRunScheduler,
    private val applicationScope: CoroutineScope,
    private val sessionStorage: SessionStorage,
    private val distanceUnitStorage: DistanceUnitStorage
) : ViewModel() {

    var state by mutableStateOf(
        RunOverviewState(
            currentDistanceUnit = distanceUnitStorage.getDistanceUnit()
        )
    )
        private set

    init {
        viewModelScope.launch {
            syncRunScheduler.scheduleSync(
                type = SyncRunScheduler.SyncType.FetchRuns(30.minutes)
            )
        }

        runRepository.getRuns().onEach { runs ->
            val runsUi = runs.map { run ->
                run.toRunUi(distanceUnitStorage.getDistanceUnit())
            }
            state = state.copy(
                runsUi = runsUi,
                runs = runs
            )
        }.launchIn(viewModelScope)

        viewModelScope.launch {
            runRepository.syncPendingRuns()
            runRepository.fetchRuns()
        }
    }

    fun onAction(action: RunOverviewAction) {
        when(action) {
            is RunOverviewAction.OnLogoutClick -> logout()
            is RunOverviewAction.DeleteRun -> {
                viewModelScope.launch {
                    runRepository.deleteRun(action.runUi.id)
                }
            }
            is RunOverviewAction.OnDistanceUnitToggle -> {
                viewModelScope.launch {
                    // Delaying long enough to ensure that the Menu dropdown has been closed before we set the selection.
                    // Otherwise, we see the selection being changed immediately and then the Menu dropdown animates closed.
                    delay(100)
                    val toggledDistanceUnit = when(state.currentDistanceUnit) {
                        DistanceUnit.MILES -> DistanceUnit.KILOMETERS
                        DistanceUnit.KILOMETERS -> DistanceUnit.MILES
                    }
                    distanceUnitStorage.setDistanceUnit(toggledDistanceUnit)
                    val runsUi = state.runs.map { run ->
                        run.toRunUi(toggledDistanceUnit)
                    }
                    state = state.copy(
                        runsUi = runsUi,
                        currentDistanceUnit = toggledDistanceUnit
                    )
                }
            }
            else -> Unit
        }
    }

    private fun logout() {
        applicationScope.launch {
            syncRunScheduler.cancelAllSyncs()
            runRepository.deleteAllRuns()
            runRepository.logout()
            sessionStorage.set(null)
        }
    }
}