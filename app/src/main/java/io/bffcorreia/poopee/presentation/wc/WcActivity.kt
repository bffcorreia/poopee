package io.bffcorreia.poopee.presentation.wc

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.squareup.picasso.Picasso
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopee.presentation.BaseActivity
import javax.inject.Inject

class WcActivity(override val layoutRes: Int = R.layout.activity_wc) : BaseActivity(),
    WcContract.View {
  @Inject lateinit var presenter: WcPresenter

  @BindView(R.id.wc_location) lateinit var wcLocation: TextView
  @BindView(R.id.wc_code) lateinit var wcCode: TextView
  @BindView(R.id.wc_price) lateinit var wcPrice: TextView
  @BindView(R.id.wc_photo) lateinit var wcPhoto: ImageView
  @BindView(R.id.wc_map) lateinit var wcMap: ImageView
  @BindView(R.id.rate) lateinit var rateView: TextView
  @BindView(R.id.clean) lateinit var cleanView: TextView
  @BindView(R.id.privacy) lateinit var privacyView: TextView
  @BindView(R.id.style) lateinit var styleView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    presenter.start(this, getIntent().getSerializableExtra("wc") as Wc)
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }

  override fun showLoadingView() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showEmptyView() {
    throw UnsupportedOperationException(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showWc(wc: Wc) {
    wcLocation.text = wc.location
    wcPrice.text = "Price: " + wc.price.toString() + "€"
    wcCode.text = "Pin code: " + wc.code
    Picasso.with(this).load(wc.photoUrl).centerCrop().resize(200, 200).into(wcPhoto)
    Picasso.with(this).load("https://www.google.com/permissions/images/maps-att.png").fit().into(wcMap)
    rateView.text = "Rate: " + wc.avgRate
    cleanView.text = "Clean: " + wc.avgClean
    privacyView.text = "Privacy: " + wc.avgPrivacy
    styleView.text = "Style: " + wc.avgStyle
  }

  @OnClick(R.id.wc_rate_button) fun onRateButtonClicked() {
    presenter.onRateButtonClicked()
  }
}