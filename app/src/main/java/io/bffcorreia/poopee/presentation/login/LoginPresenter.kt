package io.bffcorreia.poopee.presentation.login

import android.content.Intent
import io.bffcorreia.poopee.R
import io.bffcorreia.poopee.common.di.PerActivity
import io.bffcorreia.poopee.domain.session.FacebookLogin
import io.bffcorreia.poopee.domain.session.GetCurrentUser
import io.bffcorreia.poopee.domain.session.Login
import io.bffcorreia.poopee.presentation.Navigator
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

@PerActivity class LoginPresenter
@Inject constructor(private val navigator: Navigator, private val getCurrentUser: GetCurrentUser,
    private val facebookLogin: FacebookLogin, private val login: Login) : LoginContract.Presenter {

  private lateinit var view: LoginContract.View
  private val subscriptions = CompositeSubscription()

  override fun start(view: LoginContract.View) {
    this.view = view
    initView()
  }

  override fun stop() {
    if (!subscriptions.isUnsubscribed) {
      subscriptions.unsubscribe()
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    facebookLogin.onActivityResult(requestCode, resultCode, data)
  }

  override fun onLoginViewClicked() {
    val subscriber = facebookLogin.observable().subscribe(
        { accessToken -> handleFacebookAccessToken(accessToken) },
        { error -> defaultErrorHandling(error) }
    )
    subscriptions.add(subscriber)
  }

  private fun initView() {
    val subscriber = getCurrentUser.observable().subscribe(
        { user ->
          if (user != null) {
            navigator.navigateToHome()
          }
        },
        { error -> defaultErrorHandling(error) }
    )
    subscriptions.add(subscriber)
  }

  private fun handleFacebookAccessToken(token: String) {
    val subscriber = login.addParams(token).observable().subscribe(
        { user ->
          if (user != null) {
            navigator.navigateToHome()
          }
        },
        { error -> defaultErrorHandling(error) }
    )
    subscriptions.add(subscriber)
  }

  private fun defaultErrorHandling(error: Throwable) {
    if (error.message != null) {
      view.showSnackbar(error.message as String)
    } else {
      view.showSnackbar(R.string.something_went_wrong)
    }
  }
}