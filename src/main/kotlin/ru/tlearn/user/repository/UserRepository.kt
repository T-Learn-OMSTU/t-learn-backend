package ru.tlearn.user.repository

import ru.tlearn.user.model.User

interface UserRepository {
    fun findOrCreateByEmail(email: String): User
}
