package com.bobrovskii.home.presentation

import com.bobrovskii.ebookdata.domain.entity.BestSellerBook

interface HomeRouter {

	fun routeToDetail(bestSellerBook: BestSellerBook)
}