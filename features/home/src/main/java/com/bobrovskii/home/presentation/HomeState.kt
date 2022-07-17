package com.bobrovskii.home.presentation

import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.entity.BookImage

sealed interface HomeState {

	object Loading : HomeState

	data class Content(
		val bookImages: List<BookImage>,
		val bestSellerBooks: List<BestSellerBook>,
	) : HomeState
}