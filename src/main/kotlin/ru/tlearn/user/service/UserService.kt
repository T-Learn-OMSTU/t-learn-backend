package ru.tlearn.user.service

import org.springframework.stereotype.Service
import ru.tlearn.jooq.enums.UserRole
import ru.tlearn.user.model.User
import ru.tlearn.user.repository.UserRepository

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun findOrCreateByEmail(
        email: String,
        role: UserRole,
        vocab: Int,
    ): User = userRepository.findOrCreateByEmail(email, role, vocab)
}
