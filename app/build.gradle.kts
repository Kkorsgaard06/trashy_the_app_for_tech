plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.trashy"
    //compileSdk ændres fra 33 til 34 for at få dette til at virke
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.trashy"
        minSdk = 21
        //tagetSdk ændres fra 33 til 34 for at få det til at virke
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //den her er hvad der skal tilføjes for at få appen til at virke
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
}