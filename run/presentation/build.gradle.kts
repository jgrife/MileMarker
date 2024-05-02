plugins {
    alias(libs.plugins.milemarker.android.feature.ui)
}

android {
    namespace = "com.milemarker.run.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)

    implementation(libs.google.maps.android.compose)
}