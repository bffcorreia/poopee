package io.bffcorreia.poopee.presentation.wc

class WcContract {
  interface View

  interface Presenter {
    fun start(view: View)

    fun stop()
  }
}