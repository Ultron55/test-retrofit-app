plugins {
    id("com.android.application")
    id ("kotlin-android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "test.task.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "test.task.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.1.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")

    // Hilt
    implementation ("com.google.dagger:hilt-android:2.44.2")
    implementation ("com.google.android.play:core-ktx:1.8.1")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    "kapt" ("com.google.dagger:hilt-compiler:2.44.2")

    // Shared
    implementation ("androidx.preference:preference-ktx:1.2.1")

}