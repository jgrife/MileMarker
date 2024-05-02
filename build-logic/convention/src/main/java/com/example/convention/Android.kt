package com.example.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()

        defaultConfig.minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()

        compileOptions {
            isCoreLibraryDesugaringEnabled = true
            sourceCompatibility = getJavaVersion()
            targetCompatibility = getJavaVersion()
        }
    }

    dependencies {
        // Desugaring helps to make JAVA api, compatible down to api 21. Which comes in handy for certain LocalDate and LocalDateTime api
        // functions, that would only be available on api 26 and above
        "coreLibraryDesugaring"(libs.findLibrary("desugar.jdk.libs").get())
    }
}