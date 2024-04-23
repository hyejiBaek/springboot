/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.springframework.boot.spring.boot.starter.web)
    api(libs.org.springframework.boot.spring.boot.starter.data.jpa)
    api(libs.org.mariadb.jdbc.mariadb.java.client)
    api(libs.org.springframework.boot.spring.boot.starter.data.rest)
    api(libs.org.springframework.boot.spring.boot.starter.security)
    api(libs.org.springframework.security.spring.security.test)
    api(libs.io.jsonwebtoken.jjwt.api)
    api(libs.io.jsonwebtoken.jjwt.impl)
    runtimeOnly(libs.org.springframework.boot.spring.boot.devtools)
    runtimeOnly(libs.io.jsonwebtoken.jjwt.jackson)
    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
}

group = "com.packt"
version = "0.0.1-SNAPSHOT"
description = "cardatabase"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}