package io.bffcorreia.poopee.presentation.wc

import io.bffcorreia.poopee.data.model.Wc

class WcContract {
  interface View {
    fun showLoadingView()

    fun showEmptyView()

    fun showWc(events: Wc)
  }

  interface Presenter {
    fun start(view: View, wc: Wc)
    fun onRateButtonClicked()
  }
}