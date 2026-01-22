--Supprime les tables si elles existent
DROP TABLE [ROLES];
DROP TABLE [USER];

--Crée la table UTILISATEUR
CREATE TABLE [USER] (
      id_user BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
      pseudo VARCHAR(30) NOT NULL UNIQUE,
      email VARCHAR(30) NOT NULL,
      password VARCHAR(255) NOT NULL,
      first_name VARCHAR(30) NOT NULL,
      last_name VARCHAR(30) NOT NULL,
      address VARCHAR(30) NOT NULL,
      zipcode VARCHAR(10) NOT NULL,
      city VARCHAR(30) NOT NULL,
      phone VARCHAR(20) NOT NULL,
      walletPoint INTEGER NOT NULL CHECK(walletPoint >= 0),
      walletPending INTEGER NOT NULL CHECK(walletPending >= 0),
      actif BIT NOT NULL
)


--------------------------------------------------------------------------
--------------------------------------------------------------------------
--SECURITE--
--------------------------------------------------------------------------
--------------------------------------------------------------------------

--Crée la table ROLES
CREATE TABLE [ROLES](
    [pseudo] [VARCHAR](30) references [USER](pseudo),
    [role] [VARCHAR](30) NOT NULL
    PRIMARY KEY (pseudo,role)
);

--Création d'un user et d'un admin
INSERT INTO [USER] (pseudo,email,password,first_name,last_name,address,zipcode,city,phone,walletPoint,walletPending,actif)
VALUES ('user', 'user@user.com', '{bcrypt}$2a$12$SdDhU6ZnkuZU7yWjLFbzy.y9VisytQVs6g14IUkjTdrtyUm8kMm.O',
        'userFirstname', 'userLastname', 'Rue du test', '75000', 'Paris',
        '0606060606', 0, 0, 1)

INSERT INTO [USER] (pseudo,email,password,first_name,last_name,address,zipcode,city,phone,walletPoint,walletPending,actif)
VALUES ('admin', 'admin@admin.com', '{bcrypt}$2a$12$rGvVhPkyFA4B7dhvqDj5Y.WDO9NDiS1Tmoxpoq2bSzPFoZ9.WDfFm',
        'adminFirstname', 'adminLastname', 'Rue des admins', '35000', 'Rennes',
        '0707070707', 0, 0, 1)

--Attribution des rôles aux users
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('user', 'ROLE_USER');
INSERT INTO [ROLES] ([pseudo],[role]) VALUES ('admin', 'ROLE_ADMIN');