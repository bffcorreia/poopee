package io.bffcorreia.poopee.presentation

import android.app.Activity
import android.content.Intent
import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.data.model.Wc
import io.bffcorreia.poopee.presentation.rate.RateActivity
import io.bffcorreia.poopee.presentation.wc.WcActivity
import io.bffcorreia.poopee.presentation.wcs.WcsActivity
import javax.inject.Inject

@PerActivity class Navigator @Inject constructor(private val activity: Activity) {

  fun navigateToHome() {
    val intent = Intent(activity, WcsActivity::class.java)
    activity.startActivity(intent)
    activity.finish()
  }

  fun navigateToRate() {
    val intent = Intent(activity, RateActivity::class.java)
    activity.startActivity(intent)
    activity.finish()
  }

  fun navigateToWc(wc: Wc) {
    val intent = Intent(activity, WcActivity::class.java)
    intent.putExtra("wc", wc)
    activity.startActivity(intent)
    activity.finish()
  }
}

