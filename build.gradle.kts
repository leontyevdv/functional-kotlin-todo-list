plugins {
    kotlin("jvm") version "1.9.22"
}

group = "dev.oddsystems"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:5.13.8.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-server-jetty")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    testImplementation("com.ubertob.pesticide:pesticide-core:1.6.6")
    testImplementation("io.strikt:strikt-core:0.34.0")
    testImplementation("org.http4k:http4k-client-jetty")
    testImplementation("org.jsoup:jsoup:1.17.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}