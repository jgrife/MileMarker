package com.example.core.presentation.ui

import android.content.SharedPreferences

class DistanceUnitStorage(
    private val sharedPreferences: SharedPreferences
) {
    companion object {
        private const val KEY_DISTANCE_UNIT = "key_distance_unit"
    }

    fun getDistanceUnit(): DistanceUnit {
        val value = sharedPreferences.getString(KEY_DISTANCE_UNIT, DistanceUnit.MILES.name)
        return DistanceUnit.valueOf(value ?: DistanceUnit.MILES.name)
    }

    fun setDistanceUnit(unit: DistanceUnit) {
        sharedPreferences.edit().putString(KEY_DISTANCE_UNIT, unit.name).apply()
    }
}