package com.bobrovskii.ebookdata.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rate(
	val score: Double,
	val amount: Int,
) : Parcelable