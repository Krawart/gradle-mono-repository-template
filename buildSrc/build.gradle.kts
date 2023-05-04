plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.0.3")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.16.0")
}
