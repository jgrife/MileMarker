plugins {
    alias(libs.plugins.milemarker.android.library)
    alias(libs.plugins.milemarker.jvm.ktor)
}

android {
    namespace = "com.milemarker.run.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.database)
    implementation(projects.run.domain)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
    implementation(libs.androidx.work)
    implementation(libs.koin.android.workmanager)
    implementation(libs.kotlinx.serialization.json)
}