plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    namespace = "com.merv.toast.library"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
publishing {
    publications {
        create("release", MavenPublication::class) {
            groupId = "com.github.b3ddodev"
            artifactId = "Merv-Toast-Message"
            version = "1.1.4-0103-rls"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}