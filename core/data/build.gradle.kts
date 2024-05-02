plugins {
    alias(libs.plugins.milemarker.android.library)
}

android {
    namespace = "com.example.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)
}