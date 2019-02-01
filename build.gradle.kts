import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

group = "org.cleancode.training.tdd"
version = "1.0-SNAPSHOT"

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    //id("org.jetbrains.kotlin.jvm").version("1.3.11")
    kotlin("jvm") version "1.3.20"

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // or: implementation(kotlin("stdlib-jdk8"))
    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    // include JUnit 5 assertions
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")

    // JUnit 5 Runtime
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")

    // Parametrized Test
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.3.2")

    // include JUnitParams https://github.com/Pragmatists/JUnitParams
    testImplementation("pl.pragmatists:JUnitParams:1.1.1")

    // AssertJ https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.11.1")
}

application {
    // Define the main class for the application.
    mainClassName = "org.cleancode.training.tdd.fractions.DemoKt"
}

tasks.test {
    useJUnitPlatform()
}

// config JVM target to 1.8 for all kotlin compilation tasks
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}