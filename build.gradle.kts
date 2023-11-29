// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-alpha08" apply false
    id("com.android.library") version "8.1.0-alpha08" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    kotlin("kapt") version "1.8.10"
    id ("com.google.dagger.hilt.android") version "2.44.2" apply false
    id ("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}