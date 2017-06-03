package io.bffcorreia.poopee.domain.session

import com.google.firebase.auth.FirebaseAuth
import io.bffcorreia.poopee.data.mapper.UserMapper
import io.bffcorreia.poopee.data.model.User
import io.bffcorreia.poopee.domain.Executor
import io.bffcorreia.poopee.domain.UseCase
import rx.Observable
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetCurrentUser
@Inject constructor(private val firebaseAuth: FirebaseAuth, private val userMapper: UserMapper,
    @Named(Executor.IO) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<User>(subscribeOn, observeOn) {

  override fun buildUseCaseObservable(): Observable<User> {
    return Observable.just(getCurrentUser())
  }

  private fun getCurrentUser(): User? {
    val currentUser = firebaseAuth.currentUser
    if (currentUser != null) {
      return userMapper.transform(currentUser)
    }
    return null
  }
}
