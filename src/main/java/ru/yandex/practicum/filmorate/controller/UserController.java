package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    Map<Integer, User> users = new HashMap();
    private static int id = 1;


    @PostMapping
    public User create(@Valid @RequestBody User user) {
        if (user.getId() != null) {
            throw new ValidationException("Пользователь с таким id: " + user.getId() + " уже существует!");
        }
        if (user.getName() == null) {
            user = createUserWithEmptyName(user);
        }

        validateUser(user);
        user.setId(generateId());
        users.put(user.getId(), user);

        log.info("Запрос на создание пользователя успешно обработан {}", user);
        return user;
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        validateUser(user);
        User savedUser = users.get(user.getId());

        if (savedUser != null) {
            users.put(user.getId(), user);
            log.info("Запрос на изменение пользователя успешно обработан {}", user);
            return user;
        } else {
            throw new ValidationException("Пользователь с таким id - " + user.getId() + " еще не был добавлен!");
        }
    }

    @GetMapping
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    private User createUserWithEmptyName(User user) {
        return User.builder()
                .login(user.getLogin())
                .email(user.getEmail())
                .name(user.getLogin())
                .birthday(user.getBirthday())
                .build();
    }

    private void validateUser(User user) {
        if (user.getLogin().contains(" ")) {
            throw new ValidationException("Логин не может содержать пробелы");
        }
    }

    private int generateId() {
        return id++;
    }
}
