package com.bobrovskii.books.navigation

import androidx.navigation.NavController
import com.bobrovskii.books.R
import com.bobrovskii.detail.presentation.DetailRouter
import com.bobrovskii.detail.ui.DetailFragment
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.home.presentation.HomeRouter

class Navigator : HomeRouter, DetailRouter {

	private var navController: NavController? = null

	fun bind(navController: NavController) {
		this.navController = navController
	}

	fun unbind() {
		navController = null
	}

	override fun routeToDetail(bestSellerBook: BestSellerBook) {
		navController?.navigate(
			R.id.action_homeFragment_to_detailFragment,
			DetailFragment.createBundle(bestSellerBook)
		)
	}

	override fun routeBack() {
		navController?.popBackStack()
	}
}