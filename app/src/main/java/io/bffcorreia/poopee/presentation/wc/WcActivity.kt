package io.bffcorreia.poopee.presentation.wc

import android.os.Bundle
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.BaseActivity

class WcActivity(override val layoutRes: Int = R.layout.activity_wc) : BaseActivity(),
    WcContract.View {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun initializeInjector() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}