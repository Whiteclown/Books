package com.bobrovskii.ebookdata.domain.usecase

import com.bobrovskii.ebookdata.domain.entity.BookImage
import com.bobrovskii.ebookdata.domain.repository.EBookRepository
import javax.inject.Inject

class GetSimilarBooksUseCase @Inject constructor(
	private val repository: EBookRepository,
) {

	suspend operator fun invoke(): List<BookImage> =
		repository.getSimilarBooks()
}