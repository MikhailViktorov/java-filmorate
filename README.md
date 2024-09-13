## Описание
Backend часть приложения для поиска и оценки фильмов.

## Технологии и инструменты
* Java core
* Spring Boot
* REST API
* JDBC + SQL - подключение к базе данных, запросы
* Maven - управление зависимостями, многомодульность
* Docker - развертывание и контейнеризация
* Junit 5 - тестирование
* СУБД - H2
* Lombok

# Filmorate entity relationship diagramm

![Database schema](https://github.com/MikhailViktorov/java-filmorate/blob/main/DbSchema.png)

- ### Получение всех фильмов:

```SQL
SELECT *
FROM films;
```

- ### Получение всех пользователей:

```SQL
SELECT *
FROM users;   
```

-  ### Получение друзей пользователя:

```SQL
SELECT friend_id
FROM friends
WHERE user_id = ?
```

-  ### Получение топа N наиболее популярных фильмов:

```SQL
SELECT f.name AS name,
       COUNT(fl.film_id) AS count_likes
FROM films AS f
LEFT JOIN film_likes AS fl ON fl.film_id = f.id
GROUP BY f.name
ORDER BY count_likes DESC
LIMIT ?;
```

-  ### Получение жанров фильма:

```SQL
SELECT fg.genre_id AS id,
       g.name AS name
FROM film_genres AS fg
INNER JOIN genres AS g ON fg.genre_id = g.ID
WHERE fg.film_id = ?
ORDER BY fg.genre_id;
```
