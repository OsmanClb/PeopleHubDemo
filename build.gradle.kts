// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        //navigation data transfer
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6");
        //hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}
plugins {
    id("com.android.application") version "8.1.2" apply false
}