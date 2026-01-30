--------------------------------------------------------------------------
--------------------------------------------------------------------------
-- REMPLISSAGE DES TABLES
--------------------------------------------------------------------------
--------------------------------------------------------------------------

---------------------------------------------------------------------------
-- USERS
---------------------------------------------------------------------------

INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('admin', 'admin@admin.fr', '{bcrypt}$2a$10$hSCmeZHBaSRZZ8CB5dWIe.91xwnT.R7lBbvKp4Ji7pYWqQdNm1UhS',
        'Admin', 'Admin', 'Rue des Tulipes', '35000', 'Rennes', '0758454896', '0', '0', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('adrien', 'adrien@adrien.fr', '{bcrypt}$2a$10$iF6CHrHcFM7mMLlLcZOVI.51mHdzwgFVW0.XeEAt052bmVQutOF3O',
        'Adrien', 'Quintard', 'Rue des Lilas', '35000', 'Rennes', '0758454896', '100', '375', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('adrienlc', 'adrienlc@adrien.fr', '{bcrypt}$2a$10$MoubKTySCT9QB9PBb8J9CuADdUFW1vvxu9rdm71XaZbrRqSJI0l6O',
        'Adrien', 'Le Clech', 'Allée du Bouleau', '33000', 'Bordeaux', '0654154736', '300', '0', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('maud', 'maud@maud.fr', '{bcrypt}$2a$10$AQiTU3TqHdmMFFTs.CKVW.Q8EBBmQRHAUYiXDztElRUEXwlE/lTii',
        'Maud', 'Butin', 'Chemin de Caran', '54000', 'Nancy', '0606154777', '1500', '0', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('JulienProfDu35', 'desac@desac.fr', '{bcrypt}$2a$10$MSturKTLfQT1vcHoQZa82u3RfDJ9OIXAbiPHVgW6k1tHMRWkcbjIa',
        'Julien', 'LeProf', 'Chemin des mouettes', '35000', 'Rennes', '0706224677', '0', '0', 1);


---------------------------------------------------------------------------
-- ROLES
---------------------------------------------------------------------------

INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('admin', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('adrien', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('adrienlc', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('maud', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('JulienProfDu35', 'ROLE_USER');


---------------------------------------------------------------------------
-- CATEGORY
---------------------------------------------------------------------------

INSERT INTO CATEGORY (name) VALUES ('Informatique');
INSERT INTO CATEGORY (name) VALUES ('Ameublement');
INSERT INTO CATEGORY (name) VALUES ('Vêtement');
INSERT INTO CATEGORY (name) VALUES ('Sport');
INSERT INTO CATEGORY (name) VALUES ('Loisirs');


---------------------------------------------------------------------------
-- DELIVERY_ADRESS
---------------------------------------------------------------------------

INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('Rue des Pommiers', '35000', 'Rennes');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('Allée des Merisiers', '57000', 'Metz');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('Chemin des Poiriers', '54000', 'Nancy');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('Rue des Roses', '75000', 'Paris');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('Sente des fleurs', '75012', 'Paris');


---------------------------------------------------------------------------
-- ARTICLE
---------------------------------------------------------------------------

INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Pull bleu', 'Très joli pull bleu en taille 36, un accroc sur la manche', '20', '40', '2025-10-10 22:00:00', '2025-10-20 10:30:00', 'LV', '3', '1', '2', '3');
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Ordinateur HS', 'Ordinateur Asus de 2010, pour pièces', '5', '40', '2025-12-16 15:00:00', '2025-12-20 10:30:00', 'VD', '1', '2', '5', '3');
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('iPhone 12 rose', 'iPhone qui fonctionne encore très bien, mais grosse rayure sur la coque', '100', null, '2026-01-20 22:00:00', '2026-02-20 10:30:00', 'EC', '3', '5', '3', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Robe de soirée', 'Robe à paillettes taille 40', '75', null, '2026-01-17 22:00:00', '2026-02-02 10:30:00', 'EC', '1', '1', '4', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Jean délavé', 'Jean Uniqlo, je le porte encore un peu mais il est trop petit', '30', null, '2026-01-22 10:00:00', '2026-02-15 08:30:00', 'EC', '1', '4', '5', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Ballon de foot', 'Ballon quasi-neuf', '10', null, '2026-02-20 10:00:00', '2026-03-15 08:30:00', 'CR', '4', '4', '2', null);

INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Robe de princesse', 'Robe de la princesse Belle de Disney, taille 4 ans', '50', null, '2026-02-10 10:00:00', '2026-03-15 08:30:00', 'CR', '1', '4', '2', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Carte SD', 'Elle fonctionne', '20', null, '2026-02-07 10:00:00', '2026-03-15 08:30:00', 'CR', '3', '4', '2', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Ordinateur quantique', 'Il est super', '1000', null, '2026-01-07 10:00:00', '2026-03-15 08:30:00', 'EC', '3', '4', '2', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Arrosoir', 'Il arrose très bien', '5', null, '2026-01-15 10:00:00', '2026-03-15 08:30:00', 'EC', '3', '4', '2', null);
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Bulbes de tulipes', 'Rouges et jaunes', '20', null, '2026-01-07 10:00:00', '2026-03-15 08:30:00', 'EC', '3', '4', '2', null);



---------------------------------------------------------------------------
-- PROPOSAL
---------------------------------------------------------------------------

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('40', '2025-10-15 22:00:00', '1', '3', '1');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('30', '2025-10-14 21:00:00', '2', '4', '1');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('40', '2025-12-17 11:00:00', '1', '3', '2');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('105', '2026-01-21 11:00:00', '3', '2', '3');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('150', '2026-01-22 11:00:00', '2', '4', '3');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('200', '2026-01-23 11:00:00', '1', '2', '3');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('100', '2026-01-18 11:00:00', '4', '2', '4');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('120', '2026-01-19 11:00:00', '3', '5', '4');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('150', '2026-01-20 11:00:00', '2', '3', '4');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('175', '2026-01-21 11:00:00', '1', '2', '4');

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('1200', '2026-01-21 11:00:00', '1', '3', '9');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('1100', '2026-01-20 11:00:00', '2', '4', '9');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('1050', '2026-01-18 11:00:00', '3', '3', '9');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('50', '2026-01-21 11:00:00', '1', '4', '10');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('20', '2026-01-20 11:00:00', '2', '3', '10');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('18', '2026-01-18 11:00:00', '3', '1', '10');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('25', '2026-01-10 11:00:00', '1', '1', '11');
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES ('22', '2026-01-09 11:00:00', '3', '3', '11');
