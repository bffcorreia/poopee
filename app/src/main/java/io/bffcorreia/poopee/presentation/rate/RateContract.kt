package io.bffcorreia.poopee.presentation.rate

class RateContract {
  interface View {
    fun onBackPressed()
  }

  interface Presenter {
    fun start(view: View)

    fun onReviewClicked(rate: Int, clean: Int, privacy: Int, style: Int)
  }
}