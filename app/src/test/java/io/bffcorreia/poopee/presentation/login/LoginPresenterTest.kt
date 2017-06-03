package io.bffcorreia.poopee.presentation.login

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.bffcorreia.poopee.UserFactory
import io.bffcorreia.poopee.data.model.User
import io.bffcorreia.poopee.domain.session.FacebookLogin
import io.bffcorreia.poopee.domain.session.GetCurrentUser
import io.bffcorreia.poopee.domain.session.Login
import io.bffcorreia.poopee.presentation.Navigator
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import rx.Observable

class LoginPresenterTest {

  private val navigator = mock<Navigator>()
  private val getCurrentUser = mock<GetCurrentUser>()
  private val facebookLogin = mock<FacebookLogin>()
  private val login = mock<Login>()
  private val view = mock<LoginContract.View>()
  private lateinit var presenter: LoginPresenter
  private lateinit var userFactory: UserFactory

  @Before fun setup() {
    presenter = LoginPresenter(navigator, getCurrentUser, facebookLogin, login)
    userFactory = UserFactory()
    whenever(login.addParams(ArgumentMatchers.anyString())).thenReturn(login)
  }

  @After fun tearDown() {
    presenter.stop()
  }

  @Test fun navigateToHomeIfUserIsLoggedIn() {
    val user = userFactory.build()
    currentUser(user)
    presenter.start(view)
    verify(navigator).navigateToHome()
  }

  @Test fun onSuccessLoginNavigateToHome() {
    val user = userFactory.build()
    currentUser(null)
    whenever(facebookLogin.observable()).thenReturn(Observable.just("accessToken"))
    whenever(login.observable()).thenReturn(Observable.just(user))
    presenter.start(view)
    presenter.onLoginViewClicked()
    verify(navigator).navigateToHome()
  }

  @Test fun onLoginErrorShowMessage() {
    val errorMessage = "Error message"
    currentUser(null)
    whenever(facebookLogin.observable()).thenReturn(Observable.error(Throwable(errorMessage)))
    presenter.start(view)
    presenter.onLoginViewClicked()
    verify(navigator, never()).navigateToHome()
    verify(view).showSnackbar(errorMessage)
  }

  private fun currentUser(user: User?) {
    whenever(getCurrentUser.observable()).thenReturn(Observable.just(user))
  }
}
