package io.bffcorreia.poopee.presentation

import android.app.Activity
import android.content.Intent
import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.presentation.wcs.WcsActivity
import javax.inject.Inject

@PerActivity class Navigator @Inject constructor(private val activity: Activity) {

  fun navigateToHome() {
    val intent = Intent(activity, WcsActivity::class.java)
    activity.startActivity(intent)
    activity.finish()
  }
}

