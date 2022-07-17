package com.bobrovskii.detail.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobrovskii.detail.ui.adapter.viewholder.SimilarBooksViewHolder
import com.bobrovskii.ebookdata.domain.entity.BookImage

class SimilarBooksAdapter : RecyclerView.Adapter<SimilarBooksViewHolder>() {

	var similarBooks: List<BookImage>? = null
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarBooksViewHolder =
		SimilarBooksViewHolder.from(parent)

	override fun onBindViewHolder(holder: SimilarBooksViewHolder, position: Int) {
		similarBooks?.let {
			holder.bind(it[position])
		}
	}

	override fun getItemCount(): Int = similarBooks?.size ?: 0
}