package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FilmMpa {
    @NotNull
    private int id;
    private String name;
}
