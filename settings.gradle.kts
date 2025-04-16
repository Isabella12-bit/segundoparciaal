pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("androidx") {
            from(files("gradle/libs.versions.toml")) // ✅ ¡SOLO UNA VEZ!
        }
    }
}

rootProject.name = "segundoparcia"
include(":app")