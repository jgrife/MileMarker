package com.example.core.data.auth

import android.content.SharedPreferences

class AuthEncryptedSharedPreference(private val encryptedPreferences: SharedPreferences) : AuthSharedPreference {

    override fun getAll(): MutableMap<String, *> = encryptedPreferences.all

    override fun getString(key: String?, defValue: String?): String? = encryptedPreferences.getString(key, defValue)

    override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? = encryptedPreferences.getStringSet(key, defValues)

    override fun getInt(key: String?, defValue: Int): Int = encryptedPreferences.getInt(key, defValue)

    override fun getLong(key: String?, defValue: Long): Long = encryptedPreferences.getLong(key, defValue)

    override fun getFloat(key: String?, defValue: Float): Float = encryptedPreferences.getFloat(key, defValue)

    override fun getBoolean(key: String?, defValue: Boolean): Boolean = encryptedPreferences.getBoolean(key, defValue)

    override fun contains(key: String?): Boolean = encryptedPreferences.contains(key)

    override fun edit(): SharedPreferences.Editor = encryptedPreferences.edit()

    override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        encryptedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        encryptedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }
}