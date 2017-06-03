package io.bffcorreia.poopee.presentation.login

import com.azimolabs.conditionwatcher.Instruction

class AuthInstruction constructor(private val loginActivity: LoginActivity) : Instruction() {

  override fun checkCondition(): Boolean {
    if (loginActivity.isDestroyed) {
      return true
    }
    return false
  }

  override fun getDescription(): String {
    return AuthInstruction::class.java.name
  }
}
