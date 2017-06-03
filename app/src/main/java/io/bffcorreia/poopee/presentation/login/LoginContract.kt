package io.bffcorreia.poopee.presentation.login

import android.content.Intent
import android.support.annotation.StringRes

class LoginContract {
  interface View {
    fun showSnackbar(@StringRes stringRes: Int)

    fun showSnackbar(message: String)
  }

  interface Presenter {
    fun start(view: View)

    fun stop()

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

    fun onLoginViewClicked()
  }
}