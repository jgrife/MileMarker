plugins {
    alias(libs.plugins.milemarker.jvm.library)
    alias(libs.plugins.milemarker.coroutine.testing)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}