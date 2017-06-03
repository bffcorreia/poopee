package io.bffcorreia.poopee.presentation.rate

class RateContract {
  interface View

  interface Presenter {
    fun start(view: View)

    fun stop()
  }
}