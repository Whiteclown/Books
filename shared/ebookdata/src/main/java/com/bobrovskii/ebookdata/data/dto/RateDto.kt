package com.bobrovskii.ebookdata.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RateDto(
	val score: Double,
	val amount: Int,
)
