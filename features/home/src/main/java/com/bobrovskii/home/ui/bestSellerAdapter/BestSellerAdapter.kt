package com.bobrovskii.home.ui.bestSellerAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobrovskii.ebookdata.domain.entity.BestSellerBook
import com.bobrovskii.home.ui.bestSellerAdapter.viewholder.BestSellerViewHolder

class BestSellerAdapter(
	private val onItemClicked: (BestSellerBook) -> Unit,
) : RecyclerView.Adapter<BestSellerViewHolder>() {

	var bestSellerBooks: List<BestSellerBook>? = null
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder =
		BestSellerViewHolder.from(parent)

	override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
		bestSellerBooks?.let {
			holder.bind(
				it[position],
				onItemClicked,
			)
		}
	}

	override fun getItemCount(): Int = bestSellerBooks?.size ?: 0
}