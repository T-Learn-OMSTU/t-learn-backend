package ru.tlearn.user.model

import ru.tlearn.jooq.enums.UserRole

class User(
    val id: Long,
    val email: String,
    var role: UserRole,
    var vocab: Int,
) {
    override fun toString(): String = "User($id, $email, $role, $vocab)"
}
