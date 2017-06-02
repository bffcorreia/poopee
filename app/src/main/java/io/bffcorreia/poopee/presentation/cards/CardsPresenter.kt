package io.bffcorreia.poopee.presentation.cards

import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.Card
import io.bffcorreia.poopee.domain.GetCards
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import javax.inject.Inject

@PerActivity class CardsPresenter
@Inject constructor(private val getCards: GetCards) : CardsContract.Presenter {

  private lateinit var view: CardsContract.View
  private val subscriptions = CompositeSubscription()

  override fun start(view: CardsContract.View) {
    this.view = view
    initView()
  }

  override fun stop() {
    if (!subscriptions.isUnsubscribed) {
      subscriptions.unsubscribe()
    }
  }

  private fun initView() {
    val subscriber = getCards.observable().subscribe(
        { cards -> onCardsReceived(cards) },
        { error -> Timber.e(error) }
    )
    subscriptions.add(subscriber)
  }

  private fun onCardsReceived(cards: List<Card>) {
    if (cards.isNotEmpty()) {
      view.showCards(cards.toString())
    }
  }
}
