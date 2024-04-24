package ru.yandex.practicum.filmorate.storage.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {

    private Map<Integer, User> users = new HashMap<>();
    private static int id = 1;

    @Override
    public User create(User user) {
        checkLoginAndName(user);
        user.setId(generateId());
        users.put(user.getId(), user);
        log.info("Запрос на создание пользователя успешно обработан {}", user);
        return user;
    }

    @Override
    public User update(User user) {
        User savedUser = users.get(user.getId());

        if (savedUser != null) {
            users.put(user.getId(), user);
            log.info("Запрос на изменение пользователя успешно обработан {}", user);
            return user;
        } else {
            throw new UserNotFoundException("Пользователь с таким id - " + user.getId() + " еще не был добавлен!");
        }
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }


    private int generateId() {
        return id++;
    }

    private void checkLoginAndName(User user) {
        if (user.getLogin().contains(" ")) {
            throw new ValidationException("Логин содержит пробелы");
        }

        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
    }

    public User getUserById(int id) {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException("Пользователь с id = " + id + " не найден");
        }
        return users.get(id);
    }
}
