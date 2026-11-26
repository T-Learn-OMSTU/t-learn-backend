package ru.tlearn.user.service

import org.springframework.stereotype.Service
import ru.tlearn.user.model.User
import ru.tlearn.user.repository.UserRepository

@Service
class DefaultUserService(
    private val userRepository: UserRepository,
) : UserService {
    private fun String.normalizeEmail(): String = this.trim().lowercase()

    override fun findOrCreateByEmail(email: String): User = userRepository.findOrCreateByEmail(email.normalizeEmail())
}
