DELETE FROM "USERS";
ALTER TABLE "USERS" ALTER COLUMN ID RESTART WITH 1;
DELETE FROM "FILMS";
ALTER TABLE "FILMS" ALTER COLUMN ID RESTART WITH 1;

DELETE FROM "FRIENDS";
DELETE FROM "FILM_LIKES";

DELETE FROM "GENRES";
INSERT INTO GENRES (id, name)
VALUES (1, '�������'),
       (2, '�����'),
       (3, '����������'),
       (4, '�������'),
       (5, '��������������'),
       (6, '������');


DELETE FROM "MPA";
INSERT INTO  MPA (id, name)
VALUES (1, 'G'),
       (2, 'PG'),
       (3, 'PG-13'),
       (4, 'R'),
       (5, 'NC-17');