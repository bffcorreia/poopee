package io.bffcorreia.poopee.common.di

import dagger.Subcomponent
import io.bffcorreia.poopee.presentation.cards.CardsActivity
import io.bffcorreia.poopee.presentation.login.LoginActivity

@PerActivity @Subcomponent(modules = arrayOf(ActivityModule::class)) interface ActivityComponent {

  fun plus(viewModule: ViewModule): ViewComponent

  fun inject(cardsActivity: CardsActivity)

  fun inject(loginActivity: LoginActivity)
}
