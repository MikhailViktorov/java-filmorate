package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.exception.ValidationException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserController controller = new UserController();

    @Test
    public void shouldThrowExceptionIfLoginIsIncorrect() {
        User user = User.builder()
                .login("  user Login")
                .name("userName")
                .email("useremail@mail.ru")
                .birthday(LocalDate.of(1990, 1, 1))
                .build();

        Exception exception = assertThrows(
                ValidationException.class,
                () -> controller.create(user)
        );
        assertEquals("Логин не может содержать пробелы", exception.getMessage());
    }

    @Test
    public void shouldCreateUser() {
        User user = User.builder()
                .login("userLogin")
                .name("userName")
                .email("useremail@mail.ru")
                .birthday(LocalDate.of(1990, 1, 1))
                .build();
        controller.create(user);
        assertEquals(1, controller.getAll().size());

    }

}