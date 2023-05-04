import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("com.diffplug.spotless")
}

configure<SpotlessExtension> {

    java {
        target("**/*.java")
        removeUnusedImports()
        prettier(
            mapOf(
                "prettier" to "2.8.8",
                "prettier-plugin-java" to "2.1.0"
            )
        ).configFile("${rootProject.rootDir}/config/spotless/.prettierrc.yml")
    }
}
