plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
}

kotlin {
    androidLibrary {
        compileSdk = 35
        namespace = "com.dmdev.tasktracker.shared.data.database"
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "database"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.androidx.room.runtime)
                implementation(libs.sqlite.bundled)
            }
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}