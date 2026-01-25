-- SELCT TOUTES LA TABLE CATEGORY

SELECT * FROM CATEGORY;


-- SELECT PAR id_category DANS LA TABLE CATEGORY

SELECT * FROM CATEGORY WHERE id_category = :idCategory;


UPDATE CATEGORY SET name=:name WHERE id_category=:idCategory;
-- UPDATE CATEGORY SET name='test' WHERE id_category=:idCategory;

DELETE FROM CATEGORY WHERE id_category=:idCategory