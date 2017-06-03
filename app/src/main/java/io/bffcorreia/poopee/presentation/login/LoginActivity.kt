package io.bffcorreia.poopee.presentation.login

import android.content.Intent
import android.os.Bundle
import butterknife.OnClick
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.presentation.BaseActivity
import javax.inject.Inject

class LoginActivity(override val layoutRes: Int = R.layout.activity_login) : BaseActivity(),
    LoginContract.View {

  @Inject lateinit var presenter: LoginPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.start(this)
  }

  override fun initializeInjector() {
    activityComponent.inject(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.stop()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    super.onActivityResult(requestCode, resultCode, data)
    presenter.onActivityResult(requestCode, resultCode, data)
  }

  @OnClick(R.id.login_button) fun onLoginViewClicked() {
    presenter.onLoginViewClicked()
  }
}