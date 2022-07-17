package com.bobrovskii.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.usecase.GetBestSellersUseCase
import com.bobrovskii.ebookdata.domain.usecase.GetCarouselImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private val getCarouselImagesUseCase: GetCarouselImagesUseCase,
	private val getBestSellersUseCase: GetBestSellersUseCase,
	private val router: HomeRouter,
) : ViewModel() {

	private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
	val state = _state.asStateFlow()

	fun loadData() {
		if (state.value is HomeState.Loading) {
			viewModelScope.launch {
				val bookImages = getCarouselImagesUseCase()
				val bestSellerBooks = getBestSellersUseCase()

				_state.value = HomeState.Content(
					bookImages = bookImages,
					bestSellerBooks = bestSellerBooks,
				)
			}
		}
	}

	fun routeToDetail(bestSellerBook: BestSellerBook) =
		router.routeToDetail(bestSellerBook)
}