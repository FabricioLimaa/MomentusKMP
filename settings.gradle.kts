pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        // --- ADICIONE ESTA LINHA ---
        maven("https://gitlive.github.io/firebase-kotlin-sdk/maven")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // --- E ADICIONE ESTA LINHA TAMBÉM ---
        maven("https://gitlive.github.io/firebase-kotlin-sdk/maven")
    }
}

rootProject.name = "MomentusKMP"
include(":androidApp")
include(":shared")