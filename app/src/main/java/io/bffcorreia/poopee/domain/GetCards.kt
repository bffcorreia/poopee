package io.bffcorreia.poopee.domain

import io.bffcorreia.poopee.data.Card
import io.bffcorreia.poopee.data.CardRepository
import rx.Observable
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Named

class GetCards
@Inject constructor(private val cardRepository: CardRepository,
    @Named(Executor.NEW) subscribeOn: Scheduler,
    @Named(Executor.MAIN) observeOn: Scheduler) : UseCase<List<Card>>(subscribeOn, observeOn) {

  override fun buildUseCaseObservable(): Observable<List<Card>> {
    return cardRepository.getCards()
  }
}
