plugins {
    alias(libs.plugins.milemarker.android.library.compose)
}

android {
    namespace = "com.milemarker.core.presentation.ui"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.presentation.designsystem)

    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
}