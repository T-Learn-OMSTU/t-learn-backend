package ru.tlearn.user.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import ru.tlearn.user.model.UserRole
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun `creates user and returns same user on repeated call`() {
        val email = "${UUID.randomUUID()}@example.com"

        val created =
            userService.findOrCreateByEmail(
                email = email,
                role = UserRole.USER,
                vocab = 10,
            )

        val existing =
            userService.findOrCreateByEmail(
                email = email,
                role = UserRole.ADMIN,
                vocab = 999,
            )

        assertTrue(created.id > 0)
        assertEquals(created.id, existing.id)
        assertEquals(email, existing.email)
        assertEquals(UserRole.USER, existing.role)
        assertEquals(10, existing.vocab)
    }
}
