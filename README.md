# java-filmorate
Template repository for Filmorate project.

![Database schema](https://github.com/MikhailViktorov/java-filmorate/blob/main/SchemaDB.png)


- ###  Получение всех фильмов:
```postgresql
SELECT film_id, 
       title
FROM films;
```
- ###  Получение всех пользователей:
```postgresql
SELECT user_id,
       name
FROM users;   
```
-  ### Получение топа N наиболее популярных фильмов:
```postgresql
SELECT 
	f.name AS name,
	COUNT(l.film_id) AS count
FROM films AS f
LEFT JOIN likes AS l ON l.film_id = f.film_id
GROUP BY f.name
ORDER BY count DESC
LIMIT N;
```