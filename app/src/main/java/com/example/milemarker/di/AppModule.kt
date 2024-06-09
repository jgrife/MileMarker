package com.example.milemarker.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.core.data.auth.AuthEncryptedSharedPreference
import com.example.core.data.auth.AuthSharedPreference
import com.example.milemarker.MainViewModel
import com.example.milemarker.MileMarkerApp
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<AuthSharedPreference> {
        AuthEncryptedSharedPreference(
            EncryptedSharedPreferences(
                context = androidApplication(),
                fileName = "auth_pref",
                masterKey = MasterKey(androidApplication()),
                prefKeyEncryptionScheme = EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                prefValueEncryptionScheme = EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        )
    }

    single<SharedPreferences> {
        androidApplication().getSharedPreferences(
            "mile_marker",
            Context.MODE_PRIVATE
        )
    }

    single<CoroutineScope> {
        (androidApplication() as MileMarkerApp).applicationScope
    }

    viewModelOf(::MainViewModel)
}