plugins {
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.spring") version "2.3.21"
    id("org.springframework.boot") version "4.1.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"
    id("org.jooq.jooq-codegen-gradle") version "3.21.10"
    id("org.flywaydb.flyway") version "12.4.0"
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-database-postgresql:12.4.0")
        classpath("org.postgresql:postgresql:42.7.14")
    }
}

group = "ru.tlearn"
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
    implementation("org.springframework.boot:spring-boot-starter-flyway")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("tools.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
    testImplementation("org.springframework.boot:spring-boot-starter-jooq-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    jooqCodegen("org.postgresql:postgresql:42.7.14")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
    sourceSets {
        main {
            kotlin.srcDir("build/generated-src/jooq/main")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val dbUrl = System.getenv("DB_URL")
    ?: "jdbc:postgresql://localhost:${System.getenv("DB_PORT") ?: "5432"}/${System.getenv("DB_NAME") ?: "tlearn"}"
val dbUser = System.getenv("DB_USER") ?: "postgres"
val dbPassword = System.getenv("DB_PASSWORD") ?: "postgres"

jooq {
    configuration {
        jdbc {
            driver = "org.postgresql.Driver"
            url = dbUrl
            user = dbUser
            password = dbPassword
        }

        generator {
            name = "org.jooq.codegen.KotlinGenerator"

            database {
                name = "org.jooq.meta.postgres.PostgresDatabase"
                inputSchema = "public"
                includes = ".*"
            }

            generate {
                isPojos = true
                isDaos = false
            }

            target {
                packageName = "ru.tlearn.jooq"
                directory = "build/generated-src/jooq/main"
            }
        }
    }
}

flyway {
    url = dbUrl
    user = dbUser
    password = dbPassword
    locations = arrayOf("filesystem:src/main/resources/db/migration")
}

tasks.named("jooqCodegen") {
    dependsOn(tasks.named("flywayMigrate"))

    inputs.files(
        fileTree("src/main/resources/db/migration")
    )
}

tasks.register("generateDatabase") {
    group = "database"
    description = "Applies Flyway migrations and generates jOOQ classes"

    dependsOn("jooqCodegen")
}

tasks.named("compileKotlin") {
    dependsOn("generateDatabase")
}