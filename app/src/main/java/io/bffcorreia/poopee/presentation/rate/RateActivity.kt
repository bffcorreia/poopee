package io.bffcorreia.poopee.presentation.rate

import android.os.Bundle
import android.widget.SeekBar
import butterknife.BindView
import butterknife.OnClick
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.BaseActivity
import javax.inject.Inject

class RateActivity(override val layoutRes: Int = R.layout.activity_rate) : BaseActivity(),
    RateContract.View {

  @Inject lateinit var presenter: RatePresenter
  @BindView(R.id.rate) lateinit var rateView: SeekBar
  @BindView(R.id.clean) lateinit var cleanView: SeekBar
  @BindView(R.id.privacy) lateinit var privacyView: SeekBar
  @BindView(R.id.style) lateinit var styleView: SeekBar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.start(this)
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }

  @OnClick(R.id.review) fun onReviewClicked() {
    presenter.onReviewClicked(rateView.progress, cleanView.progress, privacyView.progress, styleView.progress)
  }
}