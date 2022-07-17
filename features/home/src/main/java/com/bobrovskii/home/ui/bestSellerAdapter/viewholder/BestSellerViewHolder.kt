package com.bobrovskii.home.ui.bestSellerAdapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.home.R
import com.bobrovskii.home.databinding.ItemBestSellerBookBinding

class BestSellerViewHolder(
	private val binding: ItemBestSellerBookBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		item: BestSellerBook,
		onItemClicked: (BestSellerBook) -> Unit,
	) {
		with(binding) {
			ivBook.load(item.image) {
				scale(Scale.FILL)
				transformations(RoundedCornersTransformation(15f))
			}
			tvTitle.text = item.title
			tvAuthor.text = item.author
			tvPrice.text = itemView.context.getString(R.string.price, item.price.toString())
			tvScore.text = item.rate.score.toString()
			tvAmountOfScorers.text = itemView.context.getString(R.string.amount_of_reviewers, item.rate.amount)
			itemView.setOnClickListener { onItemClicked(item) }
		}
	}

	companion object {

		fun from(parent: ViewGroup): BestSellerViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = ItemBestSellerBookBinding.inflate(layoutInflater, parent, false)
			return BestSellerViewHolder(binding)
		}
	}
}