package com.bobrovskii.books.di

import com.bobrovskii.ebookdata.data.api.EBookApi
import com.bobrovskii.ebookdata.data.repository.EBookRepositoryImpl
import com.bobrovskii.ebookdata.domain.repository.EBookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EBookDataModule {

	@Provides
	@Singleton
	fun provideEBookApi(retrofit: Retrofit): EBookApi =
		retrofit.create()

	@Provides
	@Singleton
	fun provideEBookRepository(api: EBookApi): EBookRepository =
		EBookRepositoryImpl(api)
}