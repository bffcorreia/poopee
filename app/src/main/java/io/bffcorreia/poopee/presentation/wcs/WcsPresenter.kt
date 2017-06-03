package io.bffcorreia.poopee.presentation.wcs

import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopee.domain.GetWcs
import io.bffcorreia.poopee.presentation.Navigator
import io.bffcorreia.poopees.presentation.ItemClickListener
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

@PerActivity class WcsPresenter
@Inject constructor(private val navigator: Navigator,
    private val getWcs: GetWcs) : WcsContract.Presenter {

  private lateinit var view: WcsContract.View
  private val subscriptions = CompositeSubscription()

  override fun start(view: WcsContract.View) {
    this.view = view
    initView()
  }

  override fun stop() {
    if (!subscriptions.isUnsubscribed) {
      subscriptions.unsubscribe()
    }
  }

  override fun wcClickListener(): ItemClickListener<Wc> {
    return object : ItemClickListener<Wc> {
      override fun onItemClick(item: Wc) {
        Timber.i(item.location)
      }
    }
  }

  private fun initView() {
    val subscriber = getWcs.observable().subscribe(
        { wcs -> onWcsReceived(wcs) },
        { error -> Timber.e(error) }
    )
    subscriptions.add(subscriber)
  }

  private fun onWcsReceived(wcs: List<Wc>) {
    if (wcs.isNotEmpty()) {
      view.showWcs(wcs)
    }
  }
}