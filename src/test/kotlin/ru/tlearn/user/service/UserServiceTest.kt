package ru.tlearn.user.service

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import ru.tlearn.user.model.User
import ru.tlearn.user.model.UserRole
import ru.tlearn.user.repository.UserRepository
import kotlin.test.assertEquals

class UserServiceTest {
    private val userRepository = mock(UserRepository::class.java)
    private val userService = DefaultUserService(userRepository)

    @Test
    fun `returns user created by repository`() {
        val user = User(id = 1, email = "user@example.com", role = UserRole.USER, vocab = 1)
        `when`(userRepository.findOrCreateByEmail("user@example.com")).thenReturn(user)

        val result = userService.findOrCreateByEmail("user@example.com")

        assertEquals(user, result)
    }

    @Test
    fun `normalizes email before find or create`() {
        val user = User(id = 1, email = "user@example.com", role = UserRole.USER, vocab = 1)
        `when`(userRepository.findOrCreateByEmail("user@example.com")).thenReturn(user)

        userService.findOrCreateByEmail("  User@Example.COM  ")

        verify(userRepository).findOrCreateByEmail("user@example.com")
    }
}
