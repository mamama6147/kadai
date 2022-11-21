import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation ("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly ("mysql:mysql-connector-java:8.0.30")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-aop")
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
	implementation("org.aspectj:aspectjweaver")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("com.h2database:h2")
	implementation("org.webjars:jquery:3.6.1")
	implementation("org.webjars:bootstrap:5.2.2")
	implementation("org.webjars:webjars-locator:0.45")
	implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation("org.webjars:datatables:1.12.1")
	implementation("org.webjars:datatables-plugins:1.11.4")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
