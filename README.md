# java-filmorate

Template repository for Filmorate project.

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
SELECT f.name           AS name,
       COUNT(l.film_id) AS count_likes
FROM films AS f
         LEFT JOIN likes AS l ON l.film_id = f.film_id
GROUP BY f.name
ORDER BY count DESC LIMIT N;
```

-  ### Получение жанров фильма:

```SQL
SELECT fg.GENRE_ID AS id,
       g.NAME      AS name
FROM FILM_GENRES AS fg
         INNER JOIN GENRES AS g ON fg.GENRE_ID = g.ID
WHERE fg.FILM_ID = ?
ORDER BY fg.GENRE_ID;
```
