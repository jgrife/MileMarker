plugins {
    alias(libs.plugins.milemarker.android.feature.ui)
}

android {
    namespace = "com.milemarkert.auth.presentation"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}