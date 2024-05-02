plugins {
    alias(libs.plugins.milemarker.android.library)
}

android {
    namespace = "com.milemarker.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}