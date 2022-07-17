package com.bobrovskii.ebookdata.domain.usecase

import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.repository.EBookRepository
import javax.inject.Inject

class GetBestSellersUseCase @Inject constructor(
	private val repository: EBookRepository,
) {

	suspend operator fun invoke(): List<BestSellerBook> =
		repository.getBestSellers()
}