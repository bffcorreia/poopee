package io.bffcorreia.poopee.presentation.wcs

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.bffcorreia.poopee.R

class WcHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  @BindView(R.id.wc_photo) lateinit var photoView: ImageView
  @BindView(R.id.distance) lateinit var distanceView: TextView
  @BindView(R.id.price) lateinit var priceView: TextView
  @BindView(R.id.rate) lateinit var rateView: TextView
  @BindView(R.id.wc_location) lateinit var locationView: TextView

  init {
    ButterKnife.bind(this, itemView)
  }
}