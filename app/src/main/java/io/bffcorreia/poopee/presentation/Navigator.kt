package io.bffcorreia.poopee.presentation

import android.app.Activity
import android.content.Intent
import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.presentation.cards.CardsActivity
import javax.inject.Inject

@PerActivity class Navigator @Inject constructor(private val activity: Activity) {

  fun navigateToHome() {
    val intent = Intent(activity, CardsActivity::class.java)
    activity.startActivity(intent)
    activity.finish()
  }
}

