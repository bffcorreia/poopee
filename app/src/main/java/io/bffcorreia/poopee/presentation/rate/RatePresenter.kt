package io.bffcorreia.poopee.presentation.rate

import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.model.Review
import javax.inject.Inject

@PerActivity class RatePresenter
@Inject constructor() : RateContract.Presenter {

  override fun start(view: RateContract.View) {

  }

  override fun onReviewClicked(rate: Int, clean: Int, privacy: Int, style: Int) {
    val review = Review(rate, clean, privacy, style)
  }
}