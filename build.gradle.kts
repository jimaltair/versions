import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    id("java")
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
}


idea {
    project {
        jdkName = "17"
        languageLevel = IdeaLanguageLevel(17)

        vcs = "Git"
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
