package io.bffcorreia.poopee.presentation.rate

class RateContract {
  interface View

  interface Presenter {
    fun start(view: View)

    fun onReviewClicked(rate: Int, clean: Int, privacy: Int, style: Int)
  }
}