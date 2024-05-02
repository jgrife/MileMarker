plugins {
    alias(libs.plugins.milemarker.android.library)
}

android {
    namespace = "com.example.auth.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.auth.domain)
}