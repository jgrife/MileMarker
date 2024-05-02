import com.example.convention.addFeatureUiDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("milemarker.android.library.compose")

            dependencies {
                addFeatureUiDependencies(target)
            }
        }
    }
}