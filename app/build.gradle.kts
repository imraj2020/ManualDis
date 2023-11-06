plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.mehedi.manualdiu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mehedi.manualdiu"
        minSdk = 24
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(project(mapOf("path" to ":baselib")))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val nav_version = "2.7.2"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("com.intuit.sdp:sdp-android:1.1.0")


    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    val coroutines_version = "1.7.2"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")


    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-compiler:2.46.1")



    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.fragment:fragment-ktx:1.6.1")


    val lifecycle_version = "2.6.2"


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    implementation("io.coil-kt:coil:2.4.0")

    implementation("androidx.fragment:fragment-ktx:1.6.1")

    implementation("com.airbnb.android:lottie:6.1.0")

    // Glade for images
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
}