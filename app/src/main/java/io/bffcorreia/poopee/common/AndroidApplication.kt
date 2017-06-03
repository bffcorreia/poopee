package io.bffcorreia.poopee.common

import android.app.Application
import android.os.StrictMode
import com.facebook.FacebookSdk
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
    initStrictMode()
    initTimber()
    initFacebookSdk()
  }

  private fun initApplicationComponent() {
    this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(
        ApplicationModule(this)).build()
  }

  private fun initStrictMode() {
    if (BuildConfig.DEBUG) {
      StrictMode.setThreadPolicy(
          StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyDialog().build())
      StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
    }
  }

  private fun initTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  private fun initFacebookSdk() {
    FacebookSdk.sdkInitialize(applicationContext)
  }
}