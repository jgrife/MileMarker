plugins {
    alias(libs.plugins.milemarker.android.feature.ui)
    alias(libs.plugins.mapsplatform.secrets.plugin)
    alias(libs.plugins.milemarker.coroutine.testing)
}

android {
    namespace = "com.milemarker.run.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)

    implementation(libs.google.maps.android.compose)
    implementation(libs.coil.compose)
}