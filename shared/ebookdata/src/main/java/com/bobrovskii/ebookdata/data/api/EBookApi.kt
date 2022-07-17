package com.bobrovskii.ebookdata.data.api

import com.bobrovskii.ebookdata.data.dto.BestSellerBookDto
import com.bobrovskii.ebookdata.data.dto.BookImageDto
import retrofit2.http.GET

interface EBookApi {

	@GET("stellardiver/ebookdata/carousel")
	suspend fun getCarouselImages(): List<BookImageDto>

	@GET("stellardiver/ebookdata/best")
	suspend fun getBestSellers(): List<BestSellerBookDto>

	@GET("stellardiver/ebookdata/similar")
	suspend fun getSimilarBooks(): List<BookImageDto>
}