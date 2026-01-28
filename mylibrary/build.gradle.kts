import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

}

configurations.maybeCreate("default")
artifacts.add("default", file("uikit-debug.aar"))

android {
    namespace = "com.example.uikit"
    compileSdk = 36

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11) // Replace JVM_11 with your desired Java version
        }
    }
    buildFeatures {
        compose = true
    }
}


dependencies {
    implementation(libs.androidx.ui.test.junit4)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation("androidx.navigation:navigation-compose:2.9.6")
    implementation(libs.androidx.compose.bom)
    implementation("androidx.compose.ui:ui:1.10.1")
    implementation("androidx.compose.material:material:1.10.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-test-junit4:")

    // Для SemanticsProperties и других инструментов тестирования
    implementation ("androidx.compose.ui:ui-test:1.10.1")

    // Для манифеста и других вспомогательных классов
    implementation ("androidx.test:runner:1.7.0")
    implementation ("androidx.test:rules:1.7.0")

    // Для работы с правилом createComposeRule
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.10.1")


}