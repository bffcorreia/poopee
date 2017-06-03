package io.bffcorreia.poopee.data.mapper

import com.google.firebase.auth.FirebaseUser
import io.bffcorreia.poopee.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton class UserMapper @Inject constructor() {

  fun transform(firebaseUser: FirebaseUser): User {
    return User(firebaseUser.uid, firebaseUser.displayName, firebaseUser.email,
        firebaseUser.photoUrl.toString())
  }
}