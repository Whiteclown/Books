package com.bobrovskii.detail.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.bobrovskii.detail.databinding.ItemSimilarBookBinding
import com.bobrovskii.ebookdata.domain.entity.BookImage

class SimilarBooksViewHolder(
	private val binding: ItemSimilarBookBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		item: BookImage,
	) {
		binding.ivBookCover.load(item.image) {
			scale(Scale.FILL)
			transformations(RoundedCornersTransformation(15f))
		}
	}

	companion object {

		fun from(parent: ViewGroup): SimilarBooksViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = ItemSimilarBookBinding.inflate(layoutInflater, parent, false)
			return SimilarBooksViewHolder(binding)
		}
	}
}