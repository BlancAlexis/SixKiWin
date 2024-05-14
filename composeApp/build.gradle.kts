plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    kotlin("plugin.serialization") version "1.9.0"
    id("com.google.gms.google-services").version("4.3.15").apply(false)

}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(platform("com.google.firebase:firebase-bom:30.0.1")) // This line to add the firebase bom
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.animation)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)


            api(libs.firebase.common)
            api(libs.firebase.firestore)
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

            api(libs.koin)
            api(libs.koin.compose)
            api(libs.precompose)
            api(libs.precompose.viewmodel)
            api(libs.precompose.koin)
            api(libs.ktor.client.core)
            api(libs.ktor.client.cio)
        }
    }
}

android {
    namespace = "fr.ablanc.sixkiwin"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "fr.ablanc.sixkiwin"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    apply(plugin = "com.google.gms.google-services")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    dependencies {
        // This Lines to add firebase-common
            implementation("com.google.firebase:firebase-common-ktx:20.3.3")
        debugImplementation(libs.compose.ui.tooling)
    }
}
dependencies {

}

