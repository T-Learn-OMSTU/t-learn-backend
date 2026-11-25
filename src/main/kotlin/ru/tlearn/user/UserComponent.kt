package ru.tlearn.user

import ru.tlearn.jooq.enums.UserRole
import ru.tlearn.user.model.User

interface UserComponent {
    fun findOrCreateByEmail(email: String, role: UserRole, vocab: Int): User
}