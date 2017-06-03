package io.bffcorreia.poopee.presentation.wcs

import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopees.presentation.ItemClickListener

class WcsContract {
  interface View {
    fun showLoadingView()

    fun showEmptyView()

    fun showWcs(events: List<Wc>)
  }

  interface Presenter {
    fun start(view: View)

    fun stop()

    fun wcClickListener(): ItemClickListener<Wc>
  }
}