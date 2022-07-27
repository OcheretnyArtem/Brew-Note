plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp") version PublicVersions.ksp
    id("kotlin-parcelize")
}

android {
    compileSdk = BrewNoteConfiguration.compileSdkVersion

    defaultConfig {
        minSdk = BrewNoteConfiguration.minSdkVersion
        targetSdk = BrewNoteConfiguration.targetSdkVersion


        versionCode = BrewNoteConfiguration.versionCode
        versionName = BrewNoteConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    kotlin {
        sourceSets {
            debug {
                kotlin.srcDir("build/generated/ksp/debug/kotlin")
            }
            release {
                kotlin.srcDir("build/generated/ksp/release/kotlin")
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(File("proguard-android-optimize.txt"), File("proguard-rules.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = PublicVersions.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = PublicVersions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    BrewNoteDependencies.androidxCore(this)
    BrewNoteDependencies.compose(this)
    BrewNoteDependencies.lifecycle(this)
    BrewNoteDependencies.hilt(this)
    BrewNoteDependencies.hiltNavigationCompose(this)
    BrewNoteDependencies.composeDestinations(this)
    BrewNoteDependencies.coroutines(this)
    BrewNoteDependencies.timber(this)
    BrewNoteDependencies.tests(this)

    BrewNoteModules.domain(this)
    BrewNoteModules.data(this)
}
