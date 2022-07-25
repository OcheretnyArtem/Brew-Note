import org.gradle.api.artifacts.dsl.DependencyHandler

object BrewNoteDependencies {

    //Core
    private const val androidxCore = "androidx.core:core-ktx:${Versions.androidx_core}"

    //Compose
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    private const val composeActivity =
        "androidx.activity:activity-compose:${Versions.compose_activity}"
    private const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    //Lifecycle
    private const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    private const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"

    //Hilt
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    private const val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"

    //Compose destinations
    private const val composeDestinationsCore =
        "io.github.raamcosta.compose-destinations:animations-core:${Versions.compose_destinations}"
    private const val composeDestinationsKsp =
        "io.github.raamcosta.compose-destinations:ksp:${Versions.compose_destinations}"

    //Coroutines
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    private const val coroutinesPlayServices =
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"

    //Room
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    private const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    //Timber
    private const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Tests
    private const val junit = "junit:junit:${Versions.junit}"
    private const val androidxJunit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    private const val espressoCore =
        "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    private const val composeTests = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    fun coroutines(handler: DependencyHandler) = handler.apply {
        implementation(coroutines)
        implementation(coroutinesPlayServices)
    }

    fun tests(handler: DependencyHandler) = handler.apply {
        implementation(junit)
        implementation(androidxJunit)
        implementation(espressoCore)
        implementation(composeTests)
    }

    fun timber(handler: DependencyHandler) = handler.implementation(timber)

    fun androidxCore(handler: DependencyHandler) = handler.implementation(androidxCore)

    fun lifecycle(handler: DependencyHandler) = handler.apply {
        implementation(lifecycle)
        implementation(lifecycleViewModelCompose)
    }

    fun hilt(handler: DependencyHandler) = handler.apply {
        kapt(hiltCompiler)
        implementation(hilt)
    }

    fun hiltNavigationCompose(handler: DependencyHandler) = handler.apply {
        implementation(hiltNavigationCompose)
    }

    fun room(handler: DependencyHandler) = handler.apply {
        kapt(roomCompiler)
        api(roomRuntime)
        implementation(roomKtx)
    }

    fun compose(handler: DependencyHandler) = handler.apply {
        implementation(composeUi)
        implementation(composeMaterial)
        implementation(composePreview)
        implementation(composeActivity)
        debugImplementation(composeTooling)
    }

    fun composeDestinations(handler: DependencyHandler) = handler.apply {
        implementation(composeDestinationsCore)
        ksp(composeDestinationsKsp)
    }
}
