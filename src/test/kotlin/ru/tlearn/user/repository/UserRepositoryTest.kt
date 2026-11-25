package ru.tlearn.user.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import ru.tlearn.user.model.UserRole
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `returns null when user with email does not exist`() {
        val user = userRepository.findByEmail(uniqueEmail())

        assertNull(user)
    }

    @Test
    fun `finds inserted user by email`() {
        val email = uniqueEmail()
        val inserted =
            assertNotNull(
                userRepository.insertIfNotExist(
                    email = email,
                    role = UserRole.MODERATOR,
                    vocab = 25,
                ),
            )

        val found = assertNotNull(userRepository.findByEmail(email))

        assertEquals(inserted.id, found.id)
        assertEquals(email, found.email)
        assertEquals(UserRole.MODERATOR, found.role)
        assertEquals(25, found.vocab)
    }

    @Test
    fun `insert returns null and keeps original user when email exists`() {
        val email = uniqueEmail()
        val inserted =
            assertNotNull(
                userRepository.insertIfNotExist(
                    email = email,
                    role = UserRole.USER,
                    vocab = 10,
                ),
            )

        val duplicate =
            userRepository.insertIfNotExist(
                email = email,
                role = UserRole.ADMIN,
                vocab = 999,
            )
        val found = assertNotNull(userRepository.findByEmail(email))

        assertNull(duplicate)
        assertEquals(inserted.id, found.id)
        assertEquals(UserRole.USER, found.role)
        assertEquals(10, found.vocab)
    }

    @Test
    fun `find or create returns same user on repeated call`() {
        val email = uniqueEmail()

        val created =
            userRepository.findOrCreateByEmail(
                email = email,
                role = UserRole.ADMIN,
                vocab = 50,
            )
        val existing =
            userRepository.findOrCreateByEmail(
                email = email,
                role = UserRole.USER,
                vocab = 5,
            )

        assertTrue(created.id > 0)
        assertEquals(created.id, existing.id)
        assertEquals(email, existing.email)
        assertEquals(UserRole.ADMIN, existing.role)
        assertEquals(50, existing.vocab)
    }

    private fun uniqueEmail(): String = "${UUID.randomUUID()}@example.com"
}
