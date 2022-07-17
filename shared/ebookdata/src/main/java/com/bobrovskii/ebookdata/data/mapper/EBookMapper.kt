package com.bobrovskii.ebookdata.data.mapper

import com.bobrovskii.ebookdata.data.dto.BestSellerBookDto
import com.bobrovskii.ebookdata.data.dto.BookImageDto
import com.bobrovskii.ebookdata.data.dto.RateDto
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.entity.BookImage
import com.bobrovskii.ebookdata.domain.entity.Rate

fun RateDto.toEntity() =
	Rate(
		score = score,
		amount = amount,
	)

fun BookImageDto.toEntity() =
	BookImage(
		id = id,
		image = image,
	)

fun BestSellerBookDto.toEntity() =
	BestSellerBook(
		id = id,
		title = title,
		author = author,
		price = price,
		image = image,
		rate = rate.toEntity()
	)