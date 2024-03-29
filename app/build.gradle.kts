plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.peoplehub"
    compileSdk = 34

    buildFeatures{
        dataBinding =true;
        viewBinding = true;
    }
    defaultConfig {
        applicationId = "com.example.peoplehub"
        minSdk = 24
        targetSdk = 33
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

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    //implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.5")
    implementation("androidx.navigation:navigation-ui:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.dagger:hilt-android:2.42")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.42")
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-database:20.3.0")
}