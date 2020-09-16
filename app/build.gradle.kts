plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.app"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file("app/sign/keystore.jks")
            storePassword = "mysuperpass"
            keyAlias = "mysuperpass"
            keyPassword = "mysuperpass"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile(file("proguard-rules.pro"))
        }
    }

    buildFeatures {
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //base
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.0 ")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    //di
    implementation ("org.koin:koin-android:2.1.6")

    //rx
    implementation ("com.jakewharton.rxbinding3:rxbinding:3.1.0")

    //image loader
    implementation ("com.github.bumptech.glide:glide:4.11.0")

    //page indicator
    implementation ("com.tbuonomo.andrui:viewpagerdotsindicator:4.1.2")
}
