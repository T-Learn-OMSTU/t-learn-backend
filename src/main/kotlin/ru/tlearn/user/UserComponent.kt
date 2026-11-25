package ru.tlearn.user

import ru.tlearn.user.model.UserRole
import ru.tlearn.user.model.User

interface UserComponent {
    fun findOrCreateByEmail(email: String, role: UserRole, vocab: Int): User
}