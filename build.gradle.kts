dependencies {
    // Spring Boot
    plugins {
        java
        id("org.springframework.boot") version "3.4.3"
        id("io.spring.dependency-management") version "1.1.7"
    }

    group = "com.example"
    version = "0.0.1-SNAPSHOT"

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        // Spring Boot
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.postgresql:postgresql:42.7.3")

        // Swagger
        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

        // JWT
        implementation("io.jsonwebtoken:jjwt:0.12.3")

        // Lombok
        compileOnly("org.projectlombok:lombok:1.18.32")
        annotationProcessor("org.projectlombok:lombok:1.18.32")
        testCompileOnly("org.projectlombok:lombok:1.18.32")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.32")

        // Devtools
        developmentOnly("org.springframework.boot:spring-boot-devtools")

        // Testes
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.security:spring-security-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
