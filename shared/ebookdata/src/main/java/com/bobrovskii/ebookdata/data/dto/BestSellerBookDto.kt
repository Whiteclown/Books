package com.bobrovskii.ebookdata.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BestSellerBookDto(
	val id: Long,
	val title: String,
	val author: String,
	val price: Double,
	val image: String,
	val rate: RateDto,
)
