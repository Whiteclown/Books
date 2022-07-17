pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
}

dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "Books"
include(
	":app",
	":core",
	":features:home",
	":features:detail",
	":shared:ebookdata",
)