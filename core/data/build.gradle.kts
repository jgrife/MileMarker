plugins {
    alias(libs.plugins.milemarker.android.library)
    alias(libs.plugins.milemarker.jvm.ktor)
}

android {
    namespace = "com.example.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(libs.bundles.koin)
    implementation(libs.androidx.security.crypto.ktx)
}