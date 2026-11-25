package ru.tlearn.user

import org.springframework.stereotype.Service
import ru.tlearn.user.model.UserRole
import ru.tlearn.user.model.User
import ru.tlearn.user.repository.UserRepository

@Service
class UserComponentImpl(
    val userRepository: UserRepository,
): UserComponent {
    override fun findOrCreateByEmail(email: String, role: UserRole, vocab: Int): User =
        userRepository.findOrCreateByEmail(email, role, vocab)
}