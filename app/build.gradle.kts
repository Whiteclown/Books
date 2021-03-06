plugins {
	id(Dependencies.Plugins.ANDROID_APPLICATION)
	id(Dependencies.Plugins.KOTLIN_ANDROID)
	kotlin(Dependencies.Plugins.KAPT)
	kotlin(Dependencies.Plugins.SERIALIZATION) version Dependencies.Versions.SERIALIZATION
	id(Dependencies.Plugins.HILT)
	`android-kotlin-convention`
}

android {
	defaultConfig {
		applicationId = "com.bobrovskii.books"

		versionCode = 1
		versionName = "1.0"
	}
}

dependencies {
	kapt(Dependencies.Hilt.COMPILER)
	implementation(Dependencies.Hilt.ANDROID)

	implementation(Dependencies.Core.CORE)
	implementation(Dependencies.Core.APPCOMPAT)
	implementation(Dependencies.Core.MATERIAL)

	implementation(Dependencies.Navigation.UI)
	implementation(Dependencies.Navigation.FRAGMENT)
	implementation(Dependencies.Navigation.DYNAMIC_FEATURES)

	implementation(Dependencies.Network.RETROFIT)
	implementation(Dependencies.Network.OKHTTP)
	implementation(Dependencies.Network.OKHTTP_LOGGING_INTERCEPTOR)
	implementation(Dependencies.Network.KOTLINX_SERIALIZATION)
	implementation(Dependencies.Network.KOTLINX_CONVERTER)

	implementation(Dependencies.Layout.CONSTRAINT)

	implementation(project(Modules.Shared.EBOOKDATA))
	implementation(project(Modules.Features.HOME))
	implementation(project(Modules.Features.DETAIL))
}