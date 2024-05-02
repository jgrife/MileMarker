plugins {
    alias(libs.plugins.milemarker.android.library.compose)
}

android {
    namespace = "com.milemarker.core.presentation.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)

    api(libs.androidx.compose.material3)
}