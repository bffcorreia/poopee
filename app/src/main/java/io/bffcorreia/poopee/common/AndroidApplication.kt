package io.bffcorreia.poopee.common

import android.app.Application
import io.bffcorreia.poopee.BuildConfig
import io.bffcorreia.poopee.common.di.ApplicationComponent
import io.bffcorreia.poopee.common.di.ApplicationModule
import io.bffcorreia.poopee.common.di.DaggerApplicationComponent
import timber.log.Timber

class AndroidApplication : Application() {

  lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()

    initApplicationComponent()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun initApplicationComponent() {
    this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(
        ApplicationModule(this)).build()
  }
}