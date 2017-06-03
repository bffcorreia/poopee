package io.bffcorreia.poopees.presentation

interface ItemClickListener<in T> {
  fun onItemClick(item: T)
}