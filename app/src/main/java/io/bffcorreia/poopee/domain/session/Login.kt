package io.bffcorreia.poopee.domain.session

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.kelvinapps.rxfirebase.RxFirebaseAuth
import io.bffcorreia.poopee.data.mapper.UserMapper
import io.bffcorreia.poopee.data.model.User
import io.bffcorreia.poopee.domain.Executor
import io.bffcorreia.poopee.domain.UseCase
import rx.Observable
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Named

class Login
@Inject constructor(private val auth: FirebaseAuth, private val userMapper: UserMapper,
    @Named(Executor.IO) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<User>(subscribeOn, observeOn) {

  private lateinit var credential: AuthCredential

  override fun buildUseCaseObservable(): Observable<User> {
    return RxFirebaseAuth.signInWithCredential(auth,
        credential).map { authResult -> userMapper.transform(authResult.user) }
  }

  fun addParams(token: String): Login {
    this.credential = FacebookAuthProvider.getCredential(token)
    return this
  }
}