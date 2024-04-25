package ru.yandex.practicum.filmorate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {


    private final FilmService filmService;


    @PostMapping
    public Film create(@RequestBody @Valid Film film) {
        return filmService.create(film);
    }

    @PutMapping
    public Film update(@RequestBody @Valid Film film) {
        return filmService.update(film);
    }

    @GetMapping
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable int id) {
        return filmService.getFilmById(id);
    }

    @PutMapping("/{id}/like/{userId}")
    public Film addLike(@PathVariable int id, @PathVariable int userId) {
        return filmService.addLike(id, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public Film deleteLike(@PathVariable int id, @PathVariable int userId) {
        return filmService.deleteLike(id, userId);
    }

    @GetMapping("/popular")
    public Collection<Film> getMostLikeFilms(@RequestParam(required = false) Integer count) {
        return filmService.mostLikeFilms(count);
    }


}