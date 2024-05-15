plugins {
    alias(libs.plugins.milemarker.android.library)
    alias(libs.plugins.milemarker.android.room)
}

android {
    namespace = "com.milemarker.core.database"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.org.mongodb.bson)
    implementation(libs.bundles.koin)
}