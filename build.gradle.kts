plugins {
    java
    id("com.diffplug.spotless") version "6.25.0"
    jacoco
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Change to 17 if you prefer
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat().reflowLongStrings()
        target("**/*.java")
    }
}
