package ru.yandex.practicum.filmorate.model;



import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    @Positive
    private Integer id;

    @NotBlank(message = "Электронная почта не может быть пустой")
    @Email(message = "Электронная почта не корректна")
    private String email;

    @NotBlank(message = "Логин не может быть пустым")
    private String login;

    private String name;

    @NotNull(message = "Дата рождения не может быть пустой")
    @PastOrPresent(message = "Дата рождения не может быть в будущем")
    private LocalDate birthday;

    private Set<Long> friends = new HashSet<>();
    private Set<Film> likeFilms = new HashSet<>();
}