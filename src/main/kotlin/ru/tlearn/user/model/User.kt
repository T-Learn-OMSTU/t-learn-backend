package ru.tlearn.user.model

class User(
    val id: Int,
    val email: String,
    var role: UserRole,
    var vocab: Int,
) {
    override fun toString(): String = "User($id, $email, $role, $vocab)"
}
