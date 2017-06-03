package io.bffcorreia.poopee.presentation.wc

import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopee.presentation.Navigator
import javax.inject.Inject

@PerActivity class WcPresenter
@Inject constructor(private val navigator: Navigator) : WcContract.Presenter {
  private lateinit var view: WcContract.View

  override fun start(view: WcContract.View, wc: Wc) {
    this.view = view
    initView(wc)
  }

  private fun initView(wc: Wc) {
    view.showWc(wc)
  }

  override fun onRateButtonClicked() {
    navigator.navigateToRate()
  }
}