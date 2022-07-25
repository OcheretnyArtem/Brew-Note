import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object BrewNoteModules {
    private const val app = ":app"
    private const val data = ":data"
    private const val domain = ":domain"

    fun app(handler: DependencyHandler) = with(handler) {
        implementation(project(app))
    }

    fun data(handler: DependencyHandler) = with(handler) {
        implementation(project(data))
    }

    fun domain(handler: DependencyHandler) = with(handler) {
        implementation(project(domain))
    }
}
