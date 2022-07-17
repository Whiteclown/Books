package com.bobrovskii.home.ui.carouselAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobrovskii.ebookdata.domain.entity.BookImage
import com.bobrovskii.home.ui.carouselAdapter.viewholder.CarouselViewHolder

class CarouselAdapter : RecyclerView.Adapter<CarouselViewHolder>() {

	var bookImages: List<BookImage>? = null
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder =
		CarouselViewHolder.from(parent)

	override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
		bookImages?.let {
			holder.bind(it[position])
		}
	}

	override fun getItemCount(): Int = bookImages?.size ?: 0
}