import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.ExtensionType
import com.example.convention.configureBuildTypes
import com.example.convention.configureKotlin
import com.example.convention.configureAndroid
import com.example.convention.configureApplication
import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureApplication(applicationExtension = this)
                configureAndroid(commonExtension = this)
                configureKotlin()
                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )
            }
        }
    }
}