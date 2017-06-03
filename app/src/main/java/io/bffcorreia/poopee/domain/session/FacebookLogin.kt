package io.bffcorreia.poopee.domain.session

import android.app.Activity
import android.content.Intent
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import io.bffcorreia.poopee.domain.Executor
import io.bffcorreia.poopee.domain.UseCase
import rx.Observable
import rx.Scheduler
import rx.Subscriber
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class FacebookLogin
@Inject constructor(private val activity: Activity, private val loginManager: LoginManager,
    @Named(Executor.IO) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<String>(subscribeOn, observeOn) {

  private val callbackManager = CallbackManager.Factory.create()

  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    callbackManager.onActivityResult(requestCode, resultCode, data)
  }

  override fun buildUseCaseObservable(): Observable<String> {
    return logInWithReadPermissions(Arrays.asList("email", "public_profile"))
        .map { loginResult -> loginResult.accessToken.token }
  }

  private fun logInWithReadPermissions(permissions: Collection<String>): Observable<LoginResult> {
    return Observable.create { sub ->
      loginManager.registerCallback(callbackManager, buildLoginCallback(sub))
      loginManager.logInWithReadPermissions(activity, permissions)
    }
  }

  private fun buildLoginCallback(sub: Subscriber<in LoginResult>): FacebookCallback<LoginResult> {
    return object : FacebookCallback<LoginResult> {
      override fun onSuccess(loginResult: LoginResult) {
        sub.onNext(loginResult)
        sub.onCompleted()
      }

      override fun onCancel() {
        sub.onCompleted()
      }

      override fun onError(error: FacebookException) {
        sub.onError(error)
      }
    }
  }
}
