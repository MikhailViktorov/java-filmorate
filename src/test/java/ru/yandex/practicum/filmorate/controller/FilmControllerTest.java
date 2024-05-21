package ru.yandex.practicum.filmorate.controller;

public class FilmControllerTest {
    /*
    private FilmController controller = new FilmController(new FilmService(new InMemoryFilmStorage(),new InMemoryUserStorage()));


    @Test
    public void shouldReturnErrorMessageIfFilmOld() throws IOException, InterruptedException {
        Film film = Film.builder()
                .name("filmName")
                .description("filmDescription")
                .releaseDate(LocalDate.of(1800, 11, 1))
                .duration(150)
                .build();
        Exception exception = assertThrows(
                ValidationException.class,
                () -> controller.create(film)
        );
        assertEquals("Дата релиза — не раньше 28 декабря 1895 года", exception.getMessage());
    }

    @Test
    public void shouldCreateFilm() {
        Film film = Film.builder()
                .name("filmName")
                .description("filmDescription")
                .releaseDate(LocalDate.of(2000, 11, 1))
                .duration(150)
                .build();
        controller.create(film);
        assertEquals(1, controller.getAll().size());

    }

     */
}
