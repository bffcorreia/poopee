package io.bffcorreia.poopee

import io.bffcorreia.poopee.data.Card

class CardFactory : BaseFactory<Card>() {

  override fun build(): Card {
    return Card(faker.name.name())
  }
}
