package ru.yandex.practicum.filmorate.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@Builder
public class Film {
    private Integer id;

    @NotBlank(message = "Название фильма не может быть пустым")
    private final String name;

    @Size(max = 200, message = "Максимальная длина описания — 200 символов")
    private final String description;

    private final LocalDate releaseDate;

    @Positive(message = "Продолжительность фильма должна быть положительным числом")
    private final int duration;

}
