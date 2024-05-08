plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "DesignSystem"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.resources)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.stella.music.designsystem"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        getByName("main").java.srcDirs("build/generated/moko/androidMain/src")
    }
}

multiplatformResources {
    // (필수) 반드시 입력
    multiplatformResourcesPackage = "com.stella.music.designsystem"
    // (선택) 기본값 MR
    multiplatformResourcesClassName = "SharedResources"
    // (선택) 기본값 Public
//    multiplatformResourcesVisibility = MRVisibility.Internal
    // (선택) 기본값 en
    iosBaseLocalizationRegion = "ko"
    // (선택) 기본값 "commonMain"
//    multiplatformResourcesSourceSet = "commonClientMain"
    disableStaticFrameworkWarning = true
}