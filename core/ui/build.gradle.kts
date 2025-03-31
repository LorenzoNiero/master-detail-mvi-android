plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.challenge.master_detail.ui"

    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
        }
        create("prod") {
            dimension = "environment"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get().toString()
    }
}

dependencies {
    implementation(project(":core:common"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.ui.tooling)
}