package com.bobrovskii.ebookdata.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerBook(
	val id: Long,
	val title: String,
	val author: String,
	val price: Double,
	val image: String,
	val rate: Rate,
) : Parcelable