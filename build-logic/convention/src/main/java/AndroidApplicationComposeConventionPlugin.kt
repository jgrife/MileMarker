import com.android.build.api.dsl.ApplicationExtension
import com.example.convention.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("milemarker.android.application")

            extensions.configure<ApplicationExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}