package com.bobrovskii.books.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

	private val contentType = "application/json".toMediaType()

	private val json = Json {
		ignoreUnknownKeys = true
	}

	@Provides
	@Singleton
	fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
		HttpLoggingInterceptor().apply {
			level = HttpLoggingInterceptor.Level.BODY
		}

	@Provides
	@Singleton
	fun provideOkHttpClient(
		httpLoggingInterceptor: HttpLoggingInterceptor,
	): OkHttpClient =
		OkHttpClient
			.Builder()
			.addInterceptor(httpLoggingInterceptor)
			.build()

	@Provides
	@Singleton
	fun provideRetrofit(client: OkHttpClient): Retrofit =
		Retrofit
			.Builder()
			.baseUrl("https://my-json-server.typicode.com/")
			.addConverterFactory(json.asConverterFactory(contentType))
			.client(client)
			.build()
}