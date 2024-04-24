package ru.yandex.practicum.filmorate.storage.film;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.FilmNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage {

    private static int id = 1;
    private Map<Integer, Film> films = new HashMap<>();

    @Override
    public Film create(Film film) {
        validateFilm(film);
        film.setId(generateId());
        films.put(film.getId(), film);
        log.info("Фильм успешно добавлен {}", film);
        return film;
    }

    @Override
    public Film update(Film film) {
        validateFilm(film);
        Film savedFilm = films.get(film.getId());
        if (savedFilm != null) {
            films.put(film.getId(), film);
            log.info("Фильм успешно обновлен {}", film);
            return film;
        } else {
            throw new FilmNotFoundException("Фильм с id - " + film.getId() + " не найден");
        }
    }

    @Override
    public List<Film> getAll() {
        return new ArrayList<>(films.values());
    }

    private int generateId() {
        return id++;
    }

    private void validateFilm(Film film) {
        if (film.getReleaseDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new ValidationException("Дата релиза — не раньше 28 декабря 1895 года");
        }
    }

    public Film getFilmById(int id) {
        if (!films.containsKey(id)) {
            throw new FilmNotFoundException("Фильм c id = " + id + " не найден");
        }

        return films.get(id);
    }

    public Collection<Film> getFilms() {
        return films.values();
    }
}
