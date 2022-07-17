package com.bobrovskii.ebookdata.data.repository

import com.bobrovskii.ebookdata.data.api.EBookApi
import com.bobrovskii.ebookdata.data.mapper.toEntity
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.entity.BookImage
import com.bobrovskii.ebookdata.domain.repository.EBookRepository
import javax.inject.Inject

class EBookRepositoryImpl @Inject constructor(
	private val api: EBookApi,
) : EBookRepository {

	override suspend fun getCarouselImages(): List<BookImage> =
		api.getCarouselImages().map { it.toEntity() }

	override suspend fun getBestSellers(): List<BestSellerBook> =
		api.getBestSellers().map { it.toEntity() }

	override suspend fun getSimilarBooks(): List<BookImage> =
		api.getSimilarBooks().map { it.toEntity() }
}