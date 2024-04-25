package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;
import ru.yandex.practicum.filmorate.storage.user.InMemoryUserStorage;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserControllerTest {
    private UserController controller = new UserController(new UserService(new InMemoryUserStorage()));

    @Test
    public void shouldThrowExceptionIfLoginIsIncorrect() {
        User user = new User();
        user.setLogin("  userLogin");
        user.setName("userName");
        user.setEmail("useremail@mail.ru");
        user.setBirthday(LocalDate.of(1990, 1, 1));

        Exception exception = assertThrows(
                ValidationException.class,
                () -> controller.create(user)
        );

        assertEquals("Логин содержит пробелы", exception.getMessage());
    }

    @Test
    public void shouldCreateUser() {
        User user = new User();
        user.setLogin("userLogin");
        user.setName("userName");
        user.setEmail("useremail@mail.ru");
        user.setBirthday(LocalDate.of(1990, 1, 1));
        controller.create(user);
        assertEquals(1, controller.getAll().size());

    }



}