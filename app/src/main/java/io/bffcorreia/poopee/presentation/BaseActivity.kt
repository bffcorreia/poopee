package io.bffcorreia.poopee.presentation

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import io.bffcorreia.poopee.common.AndroidApplication
import io.bffcorreia.poopee.common.di.ActivityComponent
import io.bffcorreia.poopee.common.di.ActivityModule
import io.bffcorreia.poopee.common.di.ApplicationComponent

abstract class BaseActivity : AppCompatActivity() {

  lateinit var activityComponent: ActivityComponent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutRes)
    initActivityComponent()
    initializeInjector()
    ButterKnife.bind(this)
  }

  protected abstract val layoutRes: Int

  protected abstract fun initializeInjector()

  fun showSnackbar(@StringRes stringRes: Int) {
    Snackbar.make(findViewById(android.R.id.content), stringRes, Snackbar.LENGTH_LONG).show()
  }

  fun showSnackbar(message: String) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
  }

  private fun initActivityComponent() {
    activityComponent = applicationComponent().plus(ActivityModule(this))
  }

  private fun applicationComponent(): ApplicationComponent =
      (application as AndroidApplication).applicationComponent
}
