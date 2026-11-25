package ru.tlearn.user.repository

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import ru.tlearn.jooq.tables.records.UsersRecord
import ru.tlearn.jooq.tables.references.USERS
import ru.tlearn.user.model.User
import ru.tlearn.user.model.UserRole

@Repository
class UserRepository(
    private val dsl: DSLContext,
) {
    private fun toDbRole(role: UserRole) = ru.tlearn.jooq.enums.UserRole.valueOf(role.name)

    private fun toModel(record: UsersRecord): User = User(
        id = record.id!!,
        email = record.email!!,
        role = UserRole.valueOf(record.role!!.name),
        vocab = record.vocab!!,
    )

    fun findByEmail(email: String): User? =
        dsl
            .selectFrom(USERS)
            .where(USERS.EMAIL.eq(email))
            .fetchOne()
            ?.let(::toModel)

    fun insertIfNotExist(
        email: String,
        role: UserRole,
        vocab: Int,
    ): User? =
        dsl
            .insertInto(USERS)
            .set(USERS.EMAIL, email)
            .set(USERS.ROLE, toDbRole(role))
            .set(USERS.VOCAB, vocab)
            .onConflict(USERS.EMAIL)
            .doNothing()
            .returning()
            .fetchOne()
            ?.let(::toModel)

    fun findOrCreateByEmail(
        email: String,
        role: UserRole,
        vocab: Int,
    ): User =
        insertIfNotExist(email, role, vocab)
            ?: findByEmail(email)
            ?: error("Failed to find user by email: $email")
}
