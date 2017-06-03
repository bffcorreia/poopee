package io.bffcorreia.poopee.domain

import io.bffcorreia.poopee.data.WcRepository
import io.bffcorreia.poopee.data.model.Wc
import rx.Observable
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetWcs
@Inject constructor(private val wcRepository: WcRepository,
    @Named(Executor.NEW) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<List<Wc>>(subscribeOn, observeOn) {

  override fun buildUseCaseObservable(): Observable<List<Wc>> {
    return wcRepository.getWcs()
  }
}
