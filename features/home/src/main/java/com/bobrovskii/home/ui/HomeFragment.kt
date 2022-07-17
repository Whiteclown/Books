package com.bobrovskii.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.bobrovskii.core.CarouselRV
import com.bobrovskii.home.R
import com.bobrovskii.home.databinding.FragmentHomeBinding
import com.bobrovskii.home.presentation.HomeState
import com.bobrovskii.home.presentation.HomeViewModel
import com.bobrovskii.home.ui.bestSellerAdapter.BestSellerAdapter
import com.bobrovskii.home.ui.carouselAdapter.CarouselAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!

	private val viewModel: HomeViewModel by viewModels()

	private val carouselAdapter = CarouselAdapter()
	private val bestSellerAdapter = BestSellerAdapter(
		onItemClicked = {
			viewModel.routeToDetail(it)
		}
	)

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		_binding = FragmentHomeBinding.bind(view)
		initRV()
		viewModel.state.onEach(::render).launchIn(viewModel.viewModelScope)
		viewModel.loadData()
	}

	private fun initRV() {
		binding.rvCarousel.initialize(carouselAdapter)
		binding.rvBestSellers.adapter = bestSellerAdapter
	}

	private fun render(state: HomeState) {
		when (state) {
			is HomeState.Loading -> {
				binding.loadingView.visibility = View.VISIBLE
			}

			is HomeState.Content -> {
				carouselAdapter.bookImages = state.bookImages
				bestSellerAdapter.bestSellerBooks = state.bestSellerBooks
				binding.loadingView.visibility = View.GONE
			}
		}
	}
}