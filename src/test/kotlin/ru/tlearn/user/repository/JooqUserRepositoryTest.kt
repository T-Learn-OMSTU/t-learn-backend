package ru.tlearn.user.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.postgresql.PostgreSQLContainer
import ru.tlearn.user.model.UserRole
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest
@Testcontainers
@Transactional
class JooqUserRepositoryTest {
    @Autowired
    private lateinit var userRepository: JooqUserRepository

    @Test
    fun `creates user with default role and vocab`() {
        val email = uniqueEmail()

        val created = userRepository.findOrCreateByEmail(email)

        assertTrue(created.id > 0)
        assertEquals(email, created.email)
        assertEquals(UserRole.USER, created.role)
        assertEquals(1, created.vocab)
    }

    @Test
    fun `find or create returns same user on repeated call`() {
        val email = uniqueEmail()

        val created = userRepository.findOrCreateByEmail(email)
        val existing = userRepository.findOrCreateByEmail(email)

        assertEquals(created.id, existing.id)
        assertEquals(email, existing.email)
        assertEquals(UserRole.USER, existing.role)
        assertEquals(1, existing.vocab)
    }

    private fun uniqueEmail(): String = "${UUID.randomUUID()}@example.com"

    companion object {
        @Container
        @ServiceConnection
        @JvmStatic
        val postgres: PostgreSQLContainer = PostgreSQLContainer("postgres:16-alpine")
    }
}
