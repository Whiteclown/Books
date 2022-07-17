package com.bobrovskii.ebookdata.domain.repository

import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.entity.BookImage

interface EBookRepository {

	suspend fun getCarouselImages(): List<BookImage>

	suspend fun getBestSellers(): List<BestSellerBook>

	suspend fun getSimilarBooks(): List<BookImage>
}