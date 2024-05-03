plugins {
    alias(libs.plugins.milemarker.android.library)
}

android {
    namespace = "com.milemarker.run.location"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.data)

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
}