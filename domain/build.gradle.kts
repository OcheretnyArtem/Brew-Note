plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    compileSdk = BrewNoteConfiguration.compileSdkVersion

    defaultConfig {
        minSdk = BrewNoteConfiguration.minSdkVersion
        targetSdk = BrewNoteConfiguration.targetSdkVersion


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles.add(File("consumer-rules.pro"))
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
}

dependencies {
    //Coroutines
    BrewNoteDependencies.coroutines(this)
}
