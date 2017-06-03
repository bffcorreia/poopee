package io.bffcorreia.poopee.presentation.wcs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.bffcorreia.poopee.R

class WcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  @BindView(R.id.price) lateinit var priceView: TextView

  init {
    ButterKnife.bind(this, itemView)
  }
}