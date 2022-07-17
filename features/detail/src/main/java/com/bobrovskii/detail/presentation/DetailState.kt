package com.bobrovskii.detail.presentation

import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.entity.BookImage

sealed interface DetailState {
	object Loading : DetailState

	data class Content(
		val bestSellerBook: BestSellerBook,
		val similarBooks: List<BookImage>,
	) : DetailState
}