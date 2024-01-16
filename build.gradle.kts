plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.2.1"
    id("io.micronaut.test-resources") version "4.2.1"
}

version = "0.1"
group = "com.github.graqr"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("info.picocli:picocli-codegen")
    implementation("info.picocli:picocli")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
}


application {
    mainClass.set("com.github.graqr.AugrCommand")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}


micronaut {
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("com.github.graqr.*")
    }
    testResources {
        additionalModules.add("jdbc-postgresql")
    }
}



