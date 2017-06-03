package io.bffcorreia.poopee

import io.bffcorreia.poopee.data.model.User

class UserFactory : BaseFactory<User>() {

  override fun build(): User {
    return User(faker.lorem.characters(), faker.name.name(), faker.internet.email(),
        faker.internet.url())
  }
}
