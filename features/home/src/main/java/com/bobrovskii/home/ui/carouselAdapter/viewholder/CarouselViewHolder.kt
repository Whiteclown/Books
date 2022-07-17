package com.bobrovskii.home.ui.carouselAdapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.bobrovskii.ebookdata.domain.entity.BookImage
import com.bobrovskii.home.databinding.ItemCarouselBookBinding

class CarouselViewHolder(
	private val binding: ItemCarouselBookBinding,
) : RecyclerView.ViewHolder(binding.root) {

	fun bind(
		item: BookImage,
	) {
		binding.ivBookImage.load(item.image) {
			scale(Scale.FILL)
			transformations(RoundedCornersTransformation(30f))
		}
	}

	companion object {

		fun from(parent: ViewGroup): CarouselViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val binding = ItemCarouselBookBinding.inflate(layoutInflater, parent, false)
			return CarouselViewHolder(binding)
		}
	}
}