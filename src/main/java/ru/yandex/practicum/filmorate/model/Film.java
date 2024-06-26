package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class Film {
    private Integer id;

    @NotBlank(message = "Название фильма не может быть пустым")
    private String name;

    @Size(max = 200, message = "Максимальная длина описания — 200 символов")
    private String description;

    private LocalDate releaseDate;

    @Positive(message = "Продолжительность фильма должна быть положительным числом")
    private int duration;

    private FilmMpa mpa;
    private Set<Genre> genres = new HashSet<>();

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ID", id);
        map.put("NAME", name);
        map.put("DESCRIPTION", description);
        map.put("RELEASE_DATE", releaseDate);
        map.put("DURATION", duration);
        map.put("MPA_ID", mpa.getId());
        return map;
    }

}