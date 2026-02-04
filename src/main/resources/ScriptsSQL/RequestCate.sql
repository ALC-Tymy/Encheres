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


SELECT a.id_article, a.name, a.description, a.original_point, a.final_point, a.beginning_date, a.ending_date, a.status,
       ub.id_user AS id_user_buyer, ub.pseudo AS pseudo_buyer, ub.email AS email_buyer, ub.password AS password_buyer, ub.first_name AS first_name_buyer, ub.last_name AS last_name_buyer, ub.address AS address_buyer, ub.zipcode AS zipcode_buyer, ub.city AS city_buyer, ub.phone AS phone_buyer, ub.walletPoint AS walletPoint_buyer, ub.walletPending AS walletPending_buyer, ub.actif AS actif_buyer,
       us.id_user AS id_user_seller, us.pseudo AS pseudo_seller, us.email AS email_seller, us.password AS password_seller, us.first_name AS first_name_seller, us.last_name AS last_name_seller, us.address AS address_seller, us.zipcode AS zipcode_seller, us.city AS city_seller, us.phone AS phone_seller, us.walletPoint AS walletPoint_seller, us.walletPending AS walletPending_seller, us.actif AS actif_seller,
       c.id_category, c.name AS name_category,
       da.id_delivery_address, da.address AS address_delivery_address, da.zipcode AS zipCode_delivery_address, da.city AS city_delivery_address
FROM ARTICLE a
         LEFT JOIN [USER] ub ON ub.id_user = a.id_buyer
         LEFT JOIN [USER] us ON us.id_user = a.id_seller
         LEFT JOIN CATEGORY c ON c.id_category = a.id_category
         LEFT JOIN DELIVERY_ADDRESS da ON da.id_delivery_address = a.id_del_address


--Request pour changer l'état de CR a EC
UPDATE ARTICLE SET status = 'EC' WHERE status ='CR' AND beginning_date <= SYSDATETIME();

--Request pour changer l'état de EC a VD
UPDATE ARTICLE SET status = 'VD' WHERE status ='EC' AND ending_date <= SYSDATETIME();


--Request pour ajouter une proposition de l'article.
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('100', SYSDATETIME(), :ranking, :id_buyer, :id_article)

--Request pour update les rank de tout le monde sur l'article
--Incrémente le rank de 1 de ceux déjà existent par l'id de l'article.
UPDATE PROPOSAL SET ranking = ranking + 1 WHERE id_article = 10 ;

SELECT id_article,ranking,id_buyer FROM PROPOSAL
WHERE  id_article = 10;
SELECT * from PROPOSAL;


SELECT walletPoint, walletPending FROM [USER]
WHERE id_user = 2;

--Request pour vérif si lutilisateur est deja top 1 au ranking
SELECT TOP 1 id_buyer,point_proposal
FROM PROPOSAL
WHERE ranking = 1
  AND id_article = 13
  AND id_buyer = 3 ;

SELECT walletPoint FROM [USER] where id_user = 3;

UPDATE [USER]
SET walletPoint = walletPoint - :point_proposal,
    walletPending = walletPending + :point_proposal
WHERE id_user = :id_user

SELECT final_point FROM ARTICLE where id_article = :id_article;

UPDATE [USER] SET walletPending = walletPending - :point_proposal,
                  walletPoint = walletPoint + :point_proposal
            WHERE id_user = :id_user
AND walletPending >= :point_proposal;


UPDATE ARTICLE
SET final_point = :point_proposal
WHERE id_article = 11;

Select final_point FROM ARTICLE where id_article = 11



SELECT status,id_article,final_point,id_buyer,id_seller FROM ARTICLE WHERE status ='VD'

UPDATE u SET
             u.walletPending =

FROM [USER] AS u

WHERE a.status =  'VD'

UPDATE a SET a.status = 'LV'
FROM ARTICLE AS a
WHERE status = 'VD';

