@file:JvmName("RecyclerViewUtils")

package io.bffcorreia.poopees.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun <T : RecyclerView.ViewHolder, P> T.bind(item: P, listener: ItemClickListener<P>) {
  itemView.setOnClickListener { v -> listener.onItemClick(item) }
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
