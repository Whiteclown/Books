package com.bobrovskii.books.di

import com.bobrovskii.books.navigation.Navigator
import com.bobrovskii.detail.presentation.DetailRouter
import com.bobrovskii.home.presentation.HomeRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

	@Provides
	@Singleton
	fun provideNavigator(): Navigator =
		Navigator()

	@Provides
	@Singleton
	fun provideHomeRouter(navigator: Navigator): HomeRouter =
		navigator

	@Provides
	@Singleton
	fun provideDetailRouter(navigator: Navigator): DetailRouter =
		navigator
}