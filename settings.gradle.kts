pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("org.jlleitschuh.gradle.ktlint")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MasterDetail"
include(":app")
include(":core:common")
include(":core:ui")
include(":core:network")
include(":core:domain")
include(":core:data")
include(":feature:list")
include(":feature:detail")
include(":core:navigator")
