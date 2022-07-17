package com.bobrovskii.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.ebookdata.domain.usecase.GetSimilarBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
	private val getSimilarBooksUseCase: GetSimilarBooksUseCase,
	private val router: DetailRouter,
) : ViewModel() {

	private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
	val state = _state.asStateFlow()

	fun loadData(bestSellerBook: BestSellerBook) {
		if (state.value is DetailState.Loading) {
			viewModelScope.launch {
				val similarBooks = getSimilarBooksUseCase()

				_state.value = DetailState.Content(
					bestSellerBook = bestSellerBook,
					similarBooks = similarBooks,
				)
			}
		}
	}

	fun routeBack() =
		router.routeBack()
}