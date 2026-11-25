package ru.tlearn.user.repository

import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import ru.tlearn.jooq.enums.UserRole
import ru.tlearn.jooq.tables.references.USERS
import ru.tlearn.user.model.User

@Repository
class UserRepository(
    private val dsl: DSLContext,
) {
    fun findByEmail(email: String): User? =
        dsl
            .selectFrom(USERS)
            .where(USERS.EMAIL.eq(email))
            .fetchOne()
            ?.into(User::class.java)

    fun insertIfNotExist(
        email: String,
        role: UserRole,
        vocab: Int,
    ): User? =
        dsl
            .insertInto(USERS)
            .set(USERS.EMAIL, email)
            .set(USERS.ROLE, role)
            .set(USERS.VOCAB, vocab)
            .onConflict(USERS.EMAIL)
            .doNothing()
            .returning()
            .fetchOne()
            ?.into(User::class.java)

    fun findOrCreateByEmail(
        email: String,
        role: UserRole,
        vocab: Int,
    ): User =
        insertIfNotExist(email, role, vocab)
            ?: findByEmail(email)
            ?: error("Failed to find user by email: $email")
}
