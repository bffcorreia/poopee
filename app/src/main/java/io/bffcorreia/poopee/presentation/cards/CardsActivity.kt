package io.bffcorreia.poopee.presentation.cards

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.BaseActivity
import javax.inject.Inject

class CardsActivity(override val layoutRes: Int = R.layout.activity_cards) : BaseActivity(),
    CardsContract.View {

  @Inject lateinit var presenter: CardsPresenter
  @BindView(R.id.cards) lateinit var cardsView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.start(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.stop()
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }

  override fun showCards(cards: String) {
    cardsView.text = cards
  }
}
