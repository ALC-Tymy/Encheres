-- SELECT TOUTES LA TABLE CATEGORY

SELECT *
FROM CATEGORY;

-- SELECT PAR id_category DANS LA TABLE CATEGORY

SELECT *
FROM CATEGORY
WHERE id_category = :idCategory;

-- UPDATE PAR L'idCategory
UPDATE CATEGORY
SET name=:name
WHERE id_category = :idCategory;
-- UPDATE CATEGORY SET name='test' WHERE id_category=:idCategory;

DELETE
FROM CATEGORY
WHERE id_category = :idCategory;

-- INSERT DANS LA TABLE CATEGORY UNE NOUVELLE CATEGORY
INSERT INTO CATEGORY(name)
VALUES (:name)
-- INSERT INTO CATEGORY(name) VALUES ('+1ajout')

SELECT Top 1 u.pseudo, u.email, u.password, u.actif
FROM [USER] AS u

WHERE LOWER(u.email) = LOWER('admin@admin.fr')
   OR LOWER(u.pseudo) = LOWER('admin');


SELECT pseudo,email,password FROM [USER] WHERE pseudo OR email