plugins {
    kotlin("jvm") version "1.9.10"
    application
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.walkyst:lavaplayer-fork:1.3.77")
    implementation("org.java-websocket:Java-WebSocket:1.5.3")
    implementation("ch.qos.logback:logback-classic:1.4.7")
    implementation("org.json:json:20230227")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}
