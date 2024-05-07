# java-filmorate
Template repository for Filmorate project.

![Database schema](https://github.com/MikhailViktorov/java-filmorate/blob/main/SchemaDB.png)


- ###  Получение всех фильмов:
```sh
SELECT *
FROM films;
```
- ###  Получение всех пользователей:
```sh
SELECT *
FROM users;   
```
-  ### Получение топа N наиболее популярных фильмов:
```sh
SELECT title,
       likes
FROM films
ORDER BY likes DESC
LIMIT n;
```