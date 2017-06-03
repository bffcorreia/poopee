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
    wcLocation.text = "Location: " + wc.location
    wcPrice.text = "Price: " + wc.price.toString() + "€"
    wcCode.text = "Pin code: " + wc.code
    Picasso.with(this).load(wc.photoUrl).centerCrop().resize(200, 200).into(wcPhoto)
  }

  @OnClick(R.id.wc_rate_button) fun onRateButtonClicked() {
    presenter.onRateButtonClicked()
  }
}