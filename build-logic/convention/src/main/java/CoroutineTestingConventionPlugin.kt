import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CoroutineTestingConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            dependencies {
                "testImplementation"(libs.findBundle("coroutine.testing").get())
            }
        }
    }
}