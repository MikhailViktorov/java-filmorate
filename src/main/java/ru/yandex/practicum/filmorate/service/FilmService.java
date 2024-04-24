package ru.yandex.practicum.filmorate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
import ru.yandex.practicum.filmorate.storage.user.UserStorage;

import javax.validation.Valid;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FilmService {

    private final FilmStorage filmStorage;
    private final UserStorage userStorage;

    @Autowired
    public FilmService(FilmStorage filmStorage, UserStorage userStorage) {
        this.filmStorage = filmStorage;
        this.userStorage = userStorage;
    }


    public Film create(Film film) {
        return filmStorage.create(film);
    }


    public Film update(@RequestBody @Valid Film film) {
        return filmStorage.update(film);
    }


    public List<Film> getAll() {
        return filmStorage.getAll();
    }

    public Film getFilmById(int id) {
        return filmStorage.getFilmById(id);
    }

    public Film addLike(int id, int userId) {
        Film storageFilm = filmStorage.getFilmById(id);
        User user = userStorage.getUserById(userId);

        storageFilm.setLikes(storageFilm.getLikes() + 1);
        user.getLikeFilms().add(storageFilm);

        return storageFilm;
    }

    public Film deleteLike(int filmId, int userId) {
        Film storageFilm = filmStorage.getFilmById(filmId);
        User user = userStorage.getUserById(userId);

        storageFilm.setLikes(storageFilm.getLikes() - 1);
        user.getLikeFilms().remove(storageFilm);

        return storageFilm;
    }

    public Collection<Film> mostLikeFilms(Integer count) {
        if (count == null) {
            count = 10;
        }

        return filmStorage.getFilms().stream()
                .sorted((f1, f2) -> Long.compare(f2.getLikes(), f1.getLikes()))
                .limit(count)
                .collect(Collectors.toList());
    }

}
