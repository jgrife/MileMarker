plugins {
    alias(libs.plugins.milemarker.android.library)
    alias(libs.plugins.milemarker.jvm.ktor)
}

android {
    namespace = "com.example.auth.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.auth.domain)

    implementation(libs.bundles.koin)
}