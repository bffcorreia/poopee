package io.bffcorreia.poopee.presentation.rate

import android.os.Bundle
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.BaseActivity

class RateActivity(override val layoutRes: Int = R.layout.activity_rate) : BaseActivity(),
    RateContract.View {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun initializeInjector() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}