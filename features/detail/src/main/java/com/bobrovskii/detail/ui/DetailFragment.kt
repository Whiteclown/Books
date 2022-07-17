package com.bobrovskii.detail.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.bobrovskii.detail.R
import com.bobrovskii.detail.databinding.FragmentDetailBinding
import com.bobrovskii.detail.presentation.DetailState
import com.bobrovskii.detail.presentation.DetailViewModel
import com.bobrovskii.detail.ui.adapter.SimilarBooksAdapter
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

	private var _binding: FragmentDetailBinding? = null
	private val binding get() = _binding!!

	private val viewModel: DetailViewModel by viewModels()

	private val bestSellerBook: BestSellerBook
		get() = requireNotNull(requireArguments().getParcelable(BEST_SELLER_BOOK))

	private val similarBooksAdapter = SimilarBooksAdapter()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		_binding = FragmentDetailBinding.bind(view)
		initListeners()
		initRV()
		viewModel.state.onEach(::render).launchIn(viewModel.viewModelScope)
		viewModel.loadData(bestSellerBook)
	}

	private fun initRV() {
		binding.rvSimilarBooks.adapter = similarBooksAdapter
	}

	private fun initListeners() {
		binding.ibtnClose.setOnClickListener { viewModel.routeBack() }
	}

	private fun render(state: DetailState) {
		when (state) {
			is DetailState.Loading -> {
				with(binding) {
					btnBuy.visibility = View.INVISIBLE
					btnPreview.visibility = View.INVISIBLE
					loadingView.visibility = View.VISIBLE
				}
			}

			is DetailState.Content -> {
				with(binding) {
					ivBookDetailCover.load(bestSellerBook.image) {
						scale(Scale.FILL)
						transformations(RoundedCornersTransformation(15f))
					}
					similarBooksAdapter.similarBooks = state.similarBooks
					tvBookTitle.text = state.bestSellerBook.title
					tvAuthor.text = state.bestSellerBook.author
					tvScore.text = state.bestSellerBook.rate.score.toString()
					tvReviewers.text = getString(R.string.amount_of_reviewers, state.bestSellerBook.rate.amount)
					btnBuy.text = getString(R.string.btn_buy_text, state.bestSellerBook.price.toString())
					loadingView.visibility = View.GONE
					btnBuy.visibility = View.VISIBLE
					btnPreview.visibility = View.VISIBLE
				}
			}
		}
	}

	companion object {

		private const val BEST_SELLER_BOOK = "bestSellerBook"

		fun createBundle(bestSellerBook: BestSellerBook) =
			bundleOf(
				BEST_SELLER_BOOK to bestSellerBook,
			)
	}
}