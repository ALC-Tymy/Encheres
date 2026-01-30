--------------------------------------------------------------------------
-- INSERTION DES CATÉGORIES
--------------------------------------------------------------------------
INSERT INTO CATEGORY (name) VALUES ('Informatique');
INSERT INTO CATEGORY (name) VALUES ('Ameublement');
INSERT INTO CATEGORY (name) VALUES ('Vêtement');
INSERT INTO CATEGORY (name) VALUES ('Sport');
INSERT INTO CATEGORY (name) VALUES ('Loisirs');

-- --------------------------------------------------------------------------
-- -- INSERTION DES UTILISATEURS
-- --------------------------------------------------------------------------
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('UltraSuperAdmin', 'admin', '{bcrypt}$2a$10$hSCmeZHBaSRZZ8CB5dWIe.91xwnT.R7lBbvKp4Ji7pYWqQdNm1UhS',
        'Admin', 'Admin', 'Rue des Tulipes', '35000', 'Rennes', '0758454896', '1000', '606', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('Adriii3n', 'adrien', '{bcrypt}$2a$10$iF6CHrHcFM7mMLlLcZOVI.51mHdzwgFVW0.XeEAt052bmVQutOF3O',
        'Adrien', 'Quintard', 'Rue des Lilas', '35000', 'Rennes', '0758454896', '100', '250', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('EVA4EVER', 'adrienlc', '{bcrypt}$2a$10$MoubKTySCT9QB9PBb8J9CuADdUFW1vvxu9rdm71XaZbrRqSJI0l6O',
        'Tymy', 'Le Clech', 'Allée du Bouleau', '33000', 'Bordeaux', '0654154736', '300', '992', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('xXMaudXx', 'maud', '{bcrypt}$2a$10$AQiTU3TqHdmMFFTs.CKVW.Q8EBBmQRHAUYiXDztElRUEXwlE/lTii',
        'Maud', 'Butin', 'Chemin de Caran', '54000', 'Nancy', '0606154777', '1500', '608', 1);
INSERT INTO [USER] (pseudo, email, password, first_name, last_name, address, zipcode, city, phone, walletPoint, walletPending, actif)
VALUES ('JulienProfDu35', 'desac@desac.fr', '{bcrypt}$2a$10$MSturKTLfQT1vcHoQZa82u3RfDJ9OIXAbiPHVgW6k1tHMRWkcbjIa',
        'Julien', 'LeProf', 'Chemin des mouettes', '35000', 'Rennes', '0706224677', '250', '506', 1);

--------------------------------------------------------------------------
-- INSERTION DES ADRESSES DE LIVRAISON
--------------------------------------------------------------------------
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('15 rue de la Paix', '35000', 'Rennes');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('28 avenue Victor Hugo', '35200', 'Rennes');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('42 boulevard Clemenceau', '35700', 'Rennes');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('7 impasse des Lilas', '35400', 'Saint-Malo');
INSERT INTO DELIVERY_ADDRESS (address, zipcode, city) VALUES ('33 rue des Fontaines', '35300', 'Fougères');

--------------------------------------------------------------------------
-- INSERTION DES RÔLES
--------------------------------------------------------------------------

INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('UltraSuperAdmin', 'ROLE_ADMIN');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('UltraSuperAdmin', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('Adriii3n', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('EVA4EVER', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('xXMaudXx', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('JulienProfDu35', 'ROLE_USER');

--------------------------------------------------------------------------
-- ARTICLES - VENTE NON COMMENCÉE (status 'CR')
--------------------------------------------------------------------------
-- Article 1
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Ordinateur portable Dell', 'PC portable Dell Inspiron 15, écran 15.6 pouces Full HD, processeur Intel Core i5 11ème génération, 8Go RAM, SSD 256Go. Excellent état, très peu utilisé, vendu avec chargeur d''origine et housse de protection. Idéal pour bureautique et navigation web. Garantie encore valable 6 mois.', 450, NULL, '2026-02-15 10:00:00', '2026-02-25 20:00:00', 'CR', 1, 1, 1, NULL);

-- Article 2
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Canapé 3 places tissu gris', 'Superbe canapé 3 places en tissu gris chiné, dimensions 210x90x85cm. Très confortable avec coussins épais, structure en bois massif. Acheté il y a 2 ans chez Maisons du Monde, excellent état général, quelques traces d''usage normales. Démontable pour faciliter le transport. Non fumeur, pas d''animaux.', 380, NULL, '2026-02-10 14:00:00', '2026-02-20 18:00:00', 'CR', 2, 2, 2, NULL);

-- Article 3
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Veste en cuir homme', 'Veste en cuir véritable marque Schott, taille L, couleur noir. Style perfecto, doublure intérieure en satin, 4 poches zippées. Portée une saison seulement, état comme neuf. Cuir souple et de grande qualité. Fermeture éclair latérale, col à revers. Intemporelle et très classe.', 280, NULL, '2026-02-12 09:00:00', '2026-02-22 21:00:00', 'CR', 3, 3, 3, NULL);

-- Article 4
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('VTT 27.5 pouces Rockrider', 'VTT Rockrider ST530 de Decathlon, roues 27.5 pouces, 21 vitesses Shimano. Cadre aluminium bleu et noir, freins à disques hydrauliques, fourche suspendue. Très bon état, révisé récemment chez un professionnel. Quelques rayures d''usage mais rien de grave. Idéal pour balades et chemins forestiers.', 320, NULL, '2026-02-18 11:00:00', '2026-02-28 19:00:00', 'CR', 4, 4, 4, NULL);

-- Article 5
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Console PlayStation 5', 'PlayStation 5 édition standard avec lecteur disque, 825Go. Achetée il y a 8 mois, fonctionne parfaitement. Vendue avec manette DualSense blanche, tous les câbles d''origine et boîte. Très peu utilisée car pas assez de temps pour jouer. Comme neuve, aucune rayure. Possibilité de vendre avec jeux en plus si intéressé.', 520, NULL, '2026-02-20 15:00:00', '2026-03-02 22:00:00', 'CR', 5, 5, 5, NULL);

-- Article 6
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Imprimante laser HP', 'Imprimante laser noir et blanc HP LaserJet Pro M15w. Compacte et rapide, connexion WiFi et USB. Parfaite pour un usage domestique ou petit bureau. Très économique en toner. Vendue avec toner neuf de rechange. Fonctionne parfaitement, impression rapide et silencieuse. Notice et CD d''installation inclus.', 85, NULL, '2026-02-14 13:00:00', '2026-02-24 17:00:00', 'CR', 1, 1, 1, NULL);

-- Article 7
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Table basse vintage', 'Magnifique table basse vintage années 70, plateau en formica orange et pieds compas en bois. Dimensions 120x60x40cm. Quelques traces d''usage qui lui donnent du cachet. Très stable, structure solide. Parfaite pour un intérieur rétro ou moderne. Pièce unique qui ne laisse pas indifférent.', 150, NULL, '2026-02-16 10:30:00', '2026-02-26 16:00:00', 'CR', 2, 3, 3, NULL);

-- Article 8
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Manteau long femme', 'Manteau long femme couleur camel, marque Zara, taille M. Coupe droite élégante, longueur mi-mollet, col à revers, double boutonnage. Composition 70% laine, très chaud. Porté deux hivers, bon état général. Parfait pour les températures froides. Style intemporel qui se marie avec tout.', 95, NULL, '2026-02-11 08:00:00', '2026-02-21 20:00:00', 'CR', 3, 2, 2, NULL);

-- Article 9
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Raquette tennis Wilson', 'Raquette de tennis Wilson Pro Staff 97, grip taille 2, poids 315g non cordée. Équilibre 31cm, tamis 97 pouces carrés. Utilisée une saison en club, très bon état. Cordage récent en multifilament. Vendue avec housse de protection. Raquette polyvalente pour joueur intermédiaire à confirmé.', 180, NULL, '2026-02-17 12:00:00', '2026-02-27 18:00:00', 'CR', 4, 5, 5, NULL);

-- Article 10
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Collection BD Tintin', 'Collection complète des aventures de Tintin, 23 albums, éditions Casterman. Dos toilés, couvertures cartonnées. Quelques albums anciens avec patine du temps, d''autres plus récents en excellent état. Parfait pour collection ou cadeau. Possibilité de vendre à l''unité si pas intéressé par tout.', 420, NULL, '2026-02-19 14:30:00', '2026-03-01 21:00:00', 'CR', 5, 4, 4, NULL);

--------------------------------------------------------------------------
-- ARTICLES - EN COURS DE VENTE (status 'EC')
--------------------------------------------------------------------------
-- Article 11
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('MacBook Air M1', 'Apple MacBook Air 2020 avec puce M1, 8Go RAM, SSD 256Go, écran Retina 13 pouces. Couleur gris sidéral, clavier AZERTY français. Acheté en 2021, excellent état cosmétique et fonctionnel. Batterie en parfait état avec environ 150 cycles seulement. Vendu avec chargeur MagSafe d''origine et boîte. Rapide et silencieux.', 680, 780, '2026-01-20 10:00:00', '2026-02-05 20:00:00', 'EC', 1, 2, 2, 3);

-- Article 12
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Bibliothèque IKEA Billy', 'Bibliothèque IKEA modèle Billy, coloris blanc, hauteur 202cm, largeur 80cm, profondeur 28cm. 5 étagères réglables en hauteur. Excellent état, très stable et solide. Montée avec soin, aucune vis apparente. Idéale pour livres, déco ou rangement bureau. Démontable facilement pour transport.', 45, 65, '2026-01-22 11:00:00', '2026-02-08 19:00:00', 'EC', 2, 1, 1, 4);

-- Article 13
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Basket Nike Air Max', 'Paire de baskets Nike Air Max 90, pointure 42, coloris blanc/gris/rouge. État quasi neuf, portées 3-4 fois seulement. Boîte d''origine incluse. Semelle intermédiaire en mousse et amorti Air visible au talon. Très confortables et iconiques. Aucune tâche ni défaut. Lacets de rechange fournis.', 110, 145, '2026-01-18 09:00:00', '2026-02-03 21:00:00', 'EC', 3, 5, 5, 2);

-- Article 14
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Home trainer vélo', 'Home trainer Tacx Flux S, résistance électromagnétique, compatible vélos route et VTT. Transmission directe, très silencieux. Connectivité ANT+ et Bluetooth, compatible Zwift et autres apps. Utilisé 6 mois pendant hiver dernier. Fonctionne parfaitement. Vendu avec attache rapide et notice.', 420, 480, '2026-01-25 14:00:00', '2026-02-10 18:00:00', 'EC', 4, 3, 3, 1);

-- Article 15
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Guitare acoustique Yamaha', 'Guitare acoustique Yamaha F310, caisse épicéa, manche nato, touche palissandre. Son chaud et équilibré. Parfaite pour débuter ou niveau intermédiaire. Bon état général avec traces d''usage légères. Cordes neuves montées récemment. Vendue avec housse rembourrée et accordeur électronique. Action des cordes confortable.', 140, 175, '2026-01-21 10:30:00', '2026-02-06 22:00:00', 'EC', 5, 4, 4, 5);

-- Article 16
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Écran PC 27 pouces', 'Écran PC Samsung 27 pouces, dalle IPS, résolution 2560x1440 (QHD), 75Hz. Borderless sur 3 côtés, pied réglable en hauteur et inclinaison. Connectiques HDMI et DisplayPort. Excellent état, aucun pixel mort. Parfait pour bureautique, photo ou gaming occasionnel. Vendu avec câbles HDMI et alimentation.', 220, NULL, '2026-01-26 12:00:00', '2026-02-11 16:00:00', 'EC', 1, 1, 1, NULL);

-- Article 17
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Chaise bureau ergonomique', 'Chaise de bureau ergonomique marque Markus IKEA, coloris noir. Dossier haut avec soutien lombaire, accoudoirs réglables, vérin à gaz pour hauteur d''assise. Roulettes pour parquet. Très confortable pour longues sessions. Quelques marques d''usage sur l''assise mais structure impeccable. Nettoyée et désinfectée.', 95, 120, '2026-01-19 15:00:00', '2026-02-04 17:00:00', 'EC', 2, 3, 3, 2);

-- Article 18
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Jean Levi''s 501', 'Jean Levi''s 501 original fit, taille W32 L32, couleur bleu brut. Coupe droite iconique, 100% coton denim. Porté et lavé plusieurs fois pour un aspect vintage authentique. Bon état général, pas de trous ni d''accrocs. Boutons à la braguette. Pièce intemporelle qui se bonifie avec le temps.', 55, 72, '2026-01-23 08:30:00', '2026-02-09 20:00:00', 'EC', 3, 2, 2, 4);

-- Article 19
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Tapis de yoga premium', 'Tapis de yoga Manduka PROlite, épaisseur 5mm, dimensions 180x61cm. Matière écologique, surface texturée antidérapante des deux côtés. Excellente absorption des chocs. Coloris violet. Utilisé régulièrement pendant 1 an, bon état. Nettoyé après chaque utilisation. Très durable, garantie à vie du fabricant transférable.', 75, 92, '2026-01-24 11:00:00', '2026-02-07 19:00:00', 'EC', 4, 5, 5, 3);

-- Article 20
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Appareil photo Nikon D3500', 'Reflex numérique Nikon D3500, capteur APS-C 24MP, kit avec objectif 18-55mm VR. Excellent pour débuter en photographie. Boîtier en très bon état, quelques micro-rayures sans gravité. 8500 déclenchements environ. Batterie tient bien la charge. Vendu avec chargeur, courroie, bouchons objectif et carte SD 32Go.', 380, 445, '2026-01-27 13:00:00', '2026-02-12 21:00:00', 'EC', 5, 1, 1, 4);

-- Article 21
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Clavier mécanique Logitech', 'Clavier mécanique gaming Logitech G Pro X, switches GX Blue tactiles et clicky. Rétroéclairage RGB personnalisable, format TKL compact sans pavé numérique. Câble détachable. Utilisé 1 an, fonctionne parfaitement. Toutes les touches répondent bien. Nettoyé récemment. Idéal pour gaming et frappe intensive.', 95, 128, '2026-01-28 10:00:00', '2026-02-13 18:00:00', 'EC', 1, 2, 2, 5);

-- Article 22
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Lampe sur pied design', 'Lampe sur pied design moderne, hauteur 160cm, abat-jour tissu beige, pied métal noir mat. Éclairage LED intégré, interrupteur au pied. Très bon état esthétique et fonctionnel. Parfaite pour coin lecture ou salon. Style scandinave épuré. Ampoule LED économique incluse (durée vie 20000h).', 68, 88, '2026-01-17 16:00:00', '2026-02-02 22:00:00', 'EC', 2, 4, 4, 1);

-- Article 23
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Sweat à capuche Adidas', 'Sweat à capuche Adidas Originals, taille L, coloris noir avec logo trèfle blanc. Composition 70% coton / 30% polyester. Poche kangourou, cordon de serrage. Porté régulièrement mais bien entretenu. Pas de boulochage. Lavage machine à 30°. Coupe regular fit confortable. Style streetwear intemporel.', 42, 58, '2026-01-29 09:00:00', '2026-02-14 17:00:00', 'EC', 3, 3, 3, 5);

-- Article 24
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Ballon basket Wilson', 'Ballon de basket Wilson Evolution, taille 7 (officielle), cuir composite. Utilisé en salle uniquement, très bon grip. Surface légèrement usée mais parfaitement fonctionnel. Bien gonflé, garde la pression. Idéal pour matchs ou entraînements. Un des meilleurs ballons indoor du marché.', 48, 62, '2026-01-16 14:30:00', '2026-02-01 20:00:00', 'EC', 4, 5, 5, 2);

-- Article 25
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Jeu de société Catan', 'Jeu de société Les Colons de Catane, édition standard en français. Complet avec tous les pions, cartes et plateaux. Boîte en bon état, règles du jeu incluses. Joué une dizaine de fois en famille. Pour 3-4 joueurs, durée partie environ 75min. Excellent jeu de stratégie et négociation.', 32, 45, '2026-01-15 11:00:00', '2026-01-31 19:00:00', 'EC', 5, 2, 2, 3);

-- Article 26
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Disque dur externe 2To', 'Disque dur externe Seagate 2To, USB 3.0, format 2.5 pouces portable. Compatible PC et Mac. Vitesse transfert rapide. Aucun secteur défectueux, vérifié récemment. Boîtier en plastique noir, quelques rayures superficielles. Vendu avec câble USB. Idéal pour sauvegardes ou stockage multimédia.', 58, 75, '2026-01-14 12:00:00', '2026-01-30 16:00:00', 'EC', 1, 1, 1, 3);

-- Article 27
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Étagère murale blanche', 'Lot de 3 étagères murales IKEA Lack, coloris blanc, dimensions 110x26cm chacune. Fixations murales incluses. Montées puis démontées lors déménagement, excellent état. Parfaites pour livres, cadres photos ou plantes. Faciles à installer. Chaque étagère supporte jusqu''à 12kg.', 35, NULL, '2026-01-13 15:00:00', '2026-01-29 21:00:00', 'EC', 2, 3, 3, NULL);

-- Article 28
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Écharpe cachemire beige', 'Écharpe en cachemire pur, couleur beige clair, dimensions 180x30cm. Marque Uniqlo, très douce et chaude. Portée deux hivers, excellent état sans accroc. Nettoyage à sec effectué récemment. Frange aux extrémités. Accessoire élégant et intemporel. Se marie avec toutes les tenues.', 52, 68, '2026-01-12 10:00:00', '2026-01-28 18:00:00', 'EC', 3, 4, 4, 2);

-- Article 29
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Gourde isotherme Hydro', 'Gourde isotherme Hydro Flask 950ml, coloris bleu océan. Inox double paroi, garde froid 24h et chaud 12h. Goulot large, bouchon étanche avec poignée transport. Quelques petits chocs sur le revêtement extérieur mais isolation intacte. Sans BPA. Parfaite pour sport, randonnée ou quotidien.', 28, 38, '2026-01-11 13:30:00', '2026-01-27 17:00:00', 'EC', 4, 5, 5, 1);

-- Article 30
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Puzzle 1000 pièces', 'Puzzle Ravensburger 1000 pièces, motif paysage de montagne enneigé. Complet, vérifié pièce par pièce. Fait une fois puis rangé dans la boîte. Dimensions assemblé 70x50cm. Carton épais de qualité, découpe précise. Activité relaxante pour soirées d''hiver. Notice avec image de référence incluse.', 18, 26, '2026-01-10 14:00:00', '2026-01-26 20:00:00', 'EC', 5, 3, 3, 4);

--------------------------------------------------------------------------
-- ARTICLES - VENTE TERMINÉE (status 'VD' ou 'LV')
--------------------------------------------------------------------------
-- Article 31
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Souris gaming Razer', 'Souris gaming Razer DeathAdder V2, capteur optique 20000 DPI, 8 boutons programmables. Câblée USB, éclairage RGB Chroma. Ergonomique pour droitiers. Utilisée 6 mois, excellente précision. Switches optiques très réactifs. Pieds en PTFE pour glisse fluide. Câble souple et résistant.', 55, 88, '2025-12-15 10:00:00', '2026-01-15 20:00:00', 'VD', 1, 2, 2, 4);

-- Article 32
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Miroir rectangulaire 120cm', 'Grand miroir rectangulaire 120x80cm, cadre en bois naturel clair. Fixation murale horizontale ou verticale. Glace de qualité sans distorsion. Quelques micro-rayures sur cadre. Parfait pour entrée, chambre ou salle de bain. Apporte luminosité et sensation d''espace. Système d''accroche fourni.', 85, 125, '2025-12-20 11:00:00', '2026-01-20 19:00:00', 'LV', 2, 1, 1, 3);

-- Article 33
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Blouson Teddy vintage', 'Blouson style Teddy vintage, taille M, coloris noir et blanc. Manches en simili cuir, corps en laine. Pressions dorées, poches latérales. Style college américain années 80. Bon état avec patine vintage authentique. Doublure en satin bordeaux. Coupe ajustée. Pièce originale et stylée.', 78, 105, '2025-12-10 09:00:00', '2026-01-10 21:00:00', 'VD', 3, 5, 5, 1);

-- Article 34
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Haltères réglables 20kg', 'Paire d''haltères réglables de 5 à 20kg chacun, système de réglage rapide par cadran. Compact, gain de place par rapport à set complet. Poignée ergonomique antidérapante. Utilisés régulièrement pendant 8 mois. Quelques marques d''usage mais mécanisme impeccable. Idéal musculation maison.', 180, 235, '2025-12-28 14:00:00', '2026-01-28 18:00:00', 'LV', 4, 3, 3, 2);

-- Article 35
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Enceinte Bluetooth JBL', 'Enceinte portable JBL Flip 5, coloris noir. Bluetooth 5.0, autonomie 12h, résistante à l''eau IPX7. Son puissant et équilibré avec basses profondes. Utilisée occasionnellement, fonctionne parfaitement. Batterie tient toujours la charge annoncée. Vendue avec câble USB-C. Parfaite pour extérieur.', 68, NULL, '2025-11-25 10:30:00', '2025-12-25 22:00:00', 'VD', 5, 4, 4, NULL);

-- Article 36
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Webcam Logitech C920', 'Webcam Logitech C920 HD Pro, résolution 1080p à 30fps. Autofocus rapide, correction lumière automatique. Microphones stéréo intégrés. Clip universel pour écran ou trépied. Excellent pour visioconférences et streaming. Très peu utilisée, état neuf. Compatible Windows et Mac. Câble USB 1m50.', 62, 92, '2025-12-05 12:00:00', '2026-01-05 16:00:00', 'VD', 1, 1, 1, 5);

-- Article 37
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Tabourets bar bois métal', 'Lot de 2 tabourets de bar industriels, hauteur assise 75cm. Assise bois massif, piètement métal noir. Repose-pieds circulaire. Style industriel moderne. Utilisés 6 mois dans cuisine ouverte. Très stables et confortables. Petites marques d''usage sur métal. Vendus ensemble uniquement.', 95, 142, '2025-12-18 15:00:00', '2026-01-18 17:00:00', 'LV', 2, 3, 3, 4);

-- Article 38
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Boots Chelsea cuir marron', 'Boots Chelsea homme en cuir marron, taille 43, marque Selected Homme. Cuir pleine fleur, semelle en caoutchouc crantée. Élastiques latéraux noirs, tirette arrière. Portées une saison, bon état. Petites traces sur cuir donnant aspect patiné. Confortables dès premier port. Style élégant et polyvalent.', 88, 118, '2025-11-30 08:00:00', '2025-12-30 20:00:00', 'VD', 3, 2, 2, 5);

-- Article 39
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Sac de frappe 120cm', 'Sac de frappe sur pied, hauteur 120cm, base à remplir d''eau ou sable. Rembourrage mousse haute densité, revêtement simili cuir. Utilisé pour entraînement boxe à domicile. Quelques marques d''impacts visibles. Stable et résistant. Idéal pour cardio et technique. Base actuellement vide pour transport.', 125, 168, '2025-12-22 11:00:00', '2026-01-22 19:00:00', 'LV', 4, 5, 5, 3);

-- Article 40
INSERT INTO ARTICLE (name, description, original_point, final_point, beginning_date, ending_date, status, id_category, id_del_address, id_seller, id_buyer)
VALUES ('Coffret LEGO Harry Potter', 'Coffret LEGO Harry Potter Le Château de Poudlard, 6020 pièces, référence 71043. Complet, monté puis démonté soigneusement. Toutes pièces et figurines présentes, vérifiées. Notice en excellent état. Boîte d''origine avec quelques pliures. Modèle iconique et détaillé. Âge recommandé 16+.', 380, 485, '2025-12-08 13:00:00', '2026-01-08 21:00:00', 'VD', 5, 1, 1, 4);

--------------------------------------------------------------------------
-- PROPOSITIONS (PROPOSALS)
--------------------------------------------------------------------------
-- Propositions pour Article 11 (MacBook Air M1) - id_article: 11, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (690, '2026-01-20 11:30:00', 6, 1, 11);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (710, '2026-01-20 15:45:00', 5, 5, 11);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (730, '2026-01-21 09:20:00', 4, 4, 11);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (750, '2026-01-21 18:10:00', 3, 1, 11);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (770, '2026-01-22 14:25:00', 2, 5, 11);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (780, '2026-01-23 10:05:00', 1, 3, 11);

-- Propositions pour Article 12 (Bibliothèque) - id_article: 12, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (48, '2026-01-22 12:15:00', 4, 2, 12);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (55, '2026-01-23 08:30:00', 3, 5, 12);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (60, '2026-01-24 16:45:00', 2, 3, 12);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (65, '2026-01-25 11:20:00', 1, 4, 12);

-- Propositions pour Article 13 (Basket Nike) - id_article: 13, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (115, '2026-01-18 10:30:00', 7, 3, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (120, '2026-01-18 14:20:00', 6, 1, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (125, '2026-01-19 09:15:00', 5, 4, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (130, '2026-01-19 17:40:00', 4, 3, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (135, '2026-01-20 11:25:00', 3, 1, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (140, '2026-01-21 15:10:00', 2, 4, 13);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (145, '2026-01-22 10:50:00', 1, 2, 13);

-- Propositions pour Article 14 (Home trainer) - id_article: 14, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (430, '2026-01-25 15:30:00', 5, 2, 14);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (445, '2026-01-26 09:45:00', 4, 5, 14);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (460, '2026-01-26 18:20:00', 3, 4, 14);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (470, '2026-01-27 12:10:00', 2, 2, 14);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (480, '2026-01-28 10:35:00', 1, 1, 14);

-- Propositions pour Article 15 (Guitare Yamaha) - id_article: 15, vendeur: 4
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (145, '2026-01-21 11:45:00', 6, 1, 15);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (152, '2026-01-22 08:30:00', 5, 3, 15);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (160, '2026-01-22 16:20:00', 4, 2, 15);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (165, '2026-01-23 13:15:00', 3, 1, 15);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (170, '2026-01-24 10:40:00', 2, 3, 15);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (175, '2026-01-25 15:25:00', 1, 5, 15);

-- Propositions pour Article 16 (Écran PC) - id_article: 16, vendeur: 1
-- Aucune proposition (0 proposals)

-- Propositions pour Article 17 (Chaise bureau) - id_article: 17, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (100, '2026-01-19 16:30:00', 5, 5, 17);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (108, '2026-01-20 09:15:00', 4, 4, 17);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (112, '2026-01-21 14:50:00', 3, 1, 17);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (118, '2026-01-22 11:20:00', 2, 5, 17);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (120, '2026-01-23 08:40:00', 1, 2, 17);

-- Propositions pour Article 18 (Jean Levi's) - id_article: 18, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (58, '2026-01-23 09:20:00', 4, 3, 18);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (64, '2026-01-24 13:45:00', 3, 5, 18);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (68, '2026-01-25 10:30:00', 2, 1, 18);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (72, '2026-01-26 15:15:00', 1, 4, 18);

-- Propositions pour Article 19 (Tapis yoga) - id_article: 19, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (78, '2026-01-24 12:10:00', 6, 2, 19);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (82, '2026-01-25 08:45:00', 5, 4, 19);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (85, '2026-01-25 16:30:00', 4, 1, 19);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (88, '2026-01-26 11:20:00', 3, 2, 19);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (90, '2026-01-27 09:50:00', 2, 4, 19);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (92, '2026-01-28 14:15:00', 1, 3, 19);

-- Propositions pour Article 20 (Nikon D3500) - id_article: 20, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (390, '2026-01-27 14:30:00', 7, 3, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (405, '2026-01-27 18:20:00', 6, 2, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (415, '2026-01-28 09:45:00', 5, 5, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (425, '2026-01-28 15:10:00', 4, 3, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (432, '2026-01-29 10:30:00', 3, 2, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (440, '2026-01-29 16:50:00', 2, 5, 20);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (445, '2026-01-30 11:25:00', 1, 4, 20);

-- Propositions pour Article 21 (Clavier mécanique) - id_article: 21, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (100, '2026-01-28 11:15:00', 5, 1, 21);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (110, '2026-01-28 16:40:00', 4, 3, 21);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (118, '2026-01-29 09:20:00', 3, 4, 21);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (125, '2026-01-29 14:50:00', 2, 1, 21);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (128, '2026-01-30 10:30:00', 1, 5, 21);

-- Propositions pour Article 22 (Lampe sur pied) - id_article: 22, vendeur: 4
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (70, '2026-01-17 17:20:00', 5, 2, 22);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (76, '2026-01-18 10:45:00', 4, 3, 22);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (82, '2026-01-19 14:30:00', 3, 5, 22);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (85, '2026-01-20 09:15:00', 2, 2, 22);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (88, '2026-01-21 16:40:00', 1, 1, 22);

-- Propositions pour Article 23 (Sweat Adidas) - id_article: 23, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (45, '2026-01-29 10:20:00', 3, 1, 23);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (52, '2026-01-29 15:45:00', 2, 2, 23);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (58, '2026-01-30 09:30:00', 1, 5, 23);

-- Propositions pour Article 24 (Ballon basket) - id_article: 24, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (50, '2026-01-16 15:30:00', 6, 1, 24);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (54, '2026-01-17 09:15:00', 5, 3, 24);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (56, '2026-01-18 13:40:00', 4, 4, 24);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (58, '2026-01-19 10:20:00', 3, 1, 24);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (60, '2026-01-20 16:55:00', 2, 3, 24);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (62, '2026-01-21 11:10:00', 1, 2, 24);

-- Propositions pour Article 25 (Jeu Catan) - id_article: 25, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (35, '2026-01-15 12:30:00', 4, 4, 25);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (38, '2026-01-16 08:45:00', 3, 5, 25);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (42, '2026-01-17 15:20:00', 2, 1, 25);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (45, '2026-01-18 10:40:00', 1, 3, 25);

-- Propositions pour Article 26 (Disque dur) - id_article: 26, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (62, '2026-01-14 13:20:00', 5, 2, 26);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (66, '2026-01-15 09:45:00', 4, 4, 26);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (70, '2026-01-16 14:30:00', 3, 5, 26);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (73, '2026-01-17 11:15:00', 2, 2, 26);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (75, '2026-01-18 16:50:00', 1, 3, 26);

-- Propositions pour Article 27 (Étagère murale) - id_article: 27, vendeur: 3
-- Aucune proposition (0 proposals)

-- Propositions pour Article 28 (Écharpe cachemire) - id_article: 28, vendeur: 4
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (55, '2026-01-12 11:30:00', 4, 3, 28);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (60, '2026-01-13 14:45:00', 3, 5, 28);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (65, '2026-01-14 09:20:00', 2, 1, 28);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (68, '2026-01-15 16:10:00', 1, 2, 28);

-- Propositions pour Article 29 (Gourde isotherme) - id_article: 29, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (30, '2026-01-11 14:45:00', 3, 3, 29);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (35, '2026-01-12 10:30:00', 2, 4, 29);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (38, '2026-01-13 15:20:00', 1, 1, 29);

-- Propositions pour Article 30 (Puzzle) - id_article: 30, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (20, '2026-01-10 15:15:00', 6, 1, 30);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (22, '2026-01-11 09:30:00', 5, 2, 30);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (23, '2026-01-12 13:45:00', 4, 5, 30);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (24, '2026-01-13 10:20:00', 3, 1, 30);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (25, '2026-01-14 16:35:00', 2, 2, 30);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (26, '2026-01-15 11:50:00', 1, 4, 30);

-- Propositions pour Article 31 (Souris Razer) - VENTE TERMINÉE - id_article: 31, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (60, '2025-12-15 11:30:00', 7, 1, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (65, '2025-12-16 09:45:00', 6, 3, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (72, '2025-12-17 14:20:00', 5, 5, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (78, '2025-12-18 10:15:00', 4, 1, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (82, '2025-12-19 16:30:00', 3, 3, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (85, '2025-12-20 11:45:00', 2, 5, 31);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (88, '2025-12-22 09:20:00', 1, 4, 31);

-- Propositions pour Article 32 (Miroir) - VENTE TERMINÉE - id_article: 32, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (90, '2025-12-20 12:15:00', 5, 4, 32);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (100, '2025-12-22 08:30:00', 4, 2, 32);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (110, '2025-12-24 15:45:00', 3, 5, 32);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (120, '2025-12-26 10:20:00', 2, 4, 32);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (125, '2025-12-28 14:35:00', 1, 3, 32);

-- Propositions pour Article 33 (Blouson Teddy) - VENTE TERMINÉE - id_article: 33, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (82, '2025-12-10 10:30:00', 6, 2, 33);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (88, '2025-12-12 14:45:00', 5, 3, 33);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (92, '2025-12-14 09:20:00', 4, 4, 33);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (98, '2025-12-16 16:10:00', 3, 2, 33);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (102, '2025-12-18 11:35:00', 2, 3, 33);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (105, '2025-12-20 15:50:00', 1, 1, 33);

-- Propositions pour Article 34 (Haltères) - VENTE TERMINÉE - id_article: 34, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (190, '2025-12-28 15:30:00', 8, 1, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (200, '2025-12-29 09:45:00', 7, 4, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (208, '2025-12-30 13:20:00', 6, 5, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (215, '2025-12-31 10:15:00', 5, 1, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (220, '2026-01-02 16:40:00', 4, 4, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (225, '2026-01-04 11:25:00', 3, 5, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (230, '2026-01-06 14:50:00', 2, 1, 34);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (235, '2026-01-08 09:35:00', 1, 2, 34);

-- Propositions pour Article 35 (Enceinte JBL) - VENTE TERMINÉE SANS ACHETEUR - id_article: 35, vendeur: 4
-- Aucune proposition (0 proposals)

-- Propositions pour Article 36 (Webcam) - VENTE TERMINÉE - id_article: 36, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (65, '2025-12-05 13:30:00', 5, 2, 36);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (75, '2025-12-07 09:45:00', 4, 3, 36);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (82, '2025-12-09 15:20:00', 3, 4, 36);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (88, '2025-12-11 11:10:00', 2, 2, 36);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (92, '2025-12-13 16:35:00', 1, 5, 36);

-- Propositions pour Article 37 (Tabourets) - VENTE TERMINÉE - id_article: 37, vendeur: 3
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (100, '2025-12-18 16:20:00', 6, 1, 37);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (110, '2025-12-20 10:45:00', 5, 2, 37);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (120, '2025-12-22 14:30:00', 4, 5, 37);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (130, '2025-12-24 09:15:00', 3, 1, 37);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (138, '2025-12-26 16:50:00', 2, 2, 37);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (142, '2025-12-28 11:25:00', 1, 4, 37);

-- Propositions pour Article 38 (Boots Chelsea) - VENTE TERMINÉE - id_article: 38, vendeur: 2
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (92, '2025-11-30 09:30:00', 4, 1, 38);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (102, '2025-12-02 14:45:00', 3, 3, 38);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (110, '2025-12-05 10:20:00', 2, 4, 38);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (118, '2025-12-08 16:15:00', 1, 5, 38);

-- Propositions pour Article 39 (Sac de frappe) - VENTE TERMINÉE - id_article: 39, vendeur: 5
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (130, '2025-12-22 12:15:00', 7, 1, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (138, '2025-12-24 09:30:00', 6, 2, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (145, '2025-12-26 15:45:00', 5, 4, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (152, '2025-12-28 11:20:00', 4, 1, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (158, '2025-12-30 16:35:00', 3, 2, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (165, '2026-01-02 10:50:00', 2, 4, 39);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (168, '2026-01-05 14:25:00', 1, 3, 39);

-- Propositions pour Article 40 (LEGO Harry Potter) - VENTE TERMINÉE - id_article: 40, vendeur: 1
INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (390, '2025-12-08 14:30:00', 10, 2, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (405, '2025-12-10 10:15:00', 9, 3, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (420, '2025-12-12 16:40:00', 8, 5, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (430, '2025-12-14 11:25:00', 7, 2, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (440, '2025-12-16 15:50:00', 6, 3, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (450, '2025-12-18 09:35:00', 5, 5, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (460, '2025-12-20 14:20:00', 4, 2, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (470, '2025-12-22 10:45:00', 3, 3, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (480, '2025-12-24 16:15:00', 2, 5, 40);

INSERT INTO PROPOSAL (point_proposal, date_proposal, ranking, id_buyer, id_article)
VALUES (485, '2025-12-26 12:30:00', 1, 4, 40);
