plugins {
    java
    jacoco
    checkstyle
    id("com.krawart.base-conventions")
    id("com.krawart.java-formatter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    testImplementation(platform("org.mockito:mockito-bom:5.3.1"))
    testImplementation("org.mockito:mockito-junit-jupiter")
}

tasks {
    test {
        useJUnitPlatform()
        finalizedBy("jacocoTestReport")
    }

    withType<Checkstyle>().configureEach {
        dependsOn(
            jacocoTestReport,
            jacocoTestCoverageVerification,
        )
    }

    jacocoTestReport {
        reports {
            xml.required.set(true)
            csv.required.set(false)
            html.required.set(false)
        }
    }

    jacocoTestCoverageVerification {
        violationRules {
            rule {
                element = "CLASS"
                limit {
                    counter = "LINE"
                    value = "COVEREDRATIO"
                    minimum = 1.0.toBigDecimal()
                }
            }
        }
    }

    checkstyle {
        toolVersion = "10.3.3"
        isIgnoreFailures = false
        maxWarnings = 0
        isShowViolations = true
    }

    register("coverage") {
        group = "verification"
        finalizedBy(jacocoTestReport)
        finalizedBy(jacocoTestCoverageVerification)
    }

    register("coverage-report") {
        group = "verification"
        finalizedBy(jacocoTestReport)
    }

    register("checkstyle") {
        group = "verification"
        finalizedBy("checkstyleMain")
        finalizedBy("checkstyleTest")
    }
}