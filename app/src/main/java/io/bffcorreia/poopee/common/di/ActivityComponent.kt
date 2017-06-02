package io.bffcorreia.poopee.common.di

import dagger.Subcomponent
import io.bffcorreia.poopee.presentation.cards.CardsActivity

@PerActivity @Subcomponent(modules = arrayOf(ActivityModule::class)) interface ActivityComponent {

  fun plus(viewModule: ViewModule): ViewComponent

  fun inject(cardsActivity: CardsActivity)
}
