plugins {
    alias(libs.plugins.milemarker.android.library)
    alias(libs.plugins.milemarker.jvm.ktor)
}

android {
    namespace = "com.milemarker.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)

    implementation(libs.bundles.koin)
}