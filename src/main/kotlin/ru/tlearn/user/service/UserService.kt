package ru.tlearn.user.service

import ru.tlearn.user.model.User

interface UserService {
    fun findOrCreateByEmail(email: String): User
}
