package com.bobrovskii.ebookdata.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BookImageDto(
	val id: Long,
	val image: String,
)