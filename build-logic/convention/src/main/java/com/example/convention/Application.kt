package com.example.convention

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project

internal fun Project.configureApplication(
    applicationExtension: ApplicationExtension
) {
    applicationExtension.run {
        defaultConfig {
            applicationId = libs.findVersion("projectApplicationId").get().toString()
            targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()

            versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
            versionName = libs.findVersion("projectVersionName").get().toString()
        }
    }
}