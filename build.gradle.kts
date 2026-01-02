import com.huskerdev.openglfx.plugins.utils.pom

plugins {
    `maven-publish`

    alias(libs.plugins.kotlin.jvm)
    `java-library` 
    id("utils") 
}

allprojects {
    repositories {
        mavenCentral()
    }
    group = "com.github.lorg0n" 
    version = project.property("version") ?: "dev" 
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("Grapl Fork by Lorg0n")
                description.set("A forked version of the Grapl library with custom changes.")
                url.set("https://github.com/Lorg0n/grapl")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Lorg0n")
                        name.set("Lorg0n")
                        email.set("lorgon.kv@gmail.com") 
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Lorg0n/grapl.git")
                    developerConnection.set("scm:git:ssh://github.com/Lorg0n/grapl.git")
                    url.set("https://github.com/Lorg0n/grapl/tree/main")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Lorg0n/grapl")
            credentials {
                username = System.getenv("GPR_USER")
                password = System.getenv("GPR_KEY")
            }
        }
    }
}